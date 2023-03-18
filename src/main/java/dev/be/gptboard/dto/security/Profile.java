package dev.be.gptboard.dto.security;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Profile {
    private final String nickname;
    public static Profile from(Map<String, Object> attributes) {
        return builder()
            .nickname(String.valueOf(attributes.get("nickname")))
            .build();
    }
}
