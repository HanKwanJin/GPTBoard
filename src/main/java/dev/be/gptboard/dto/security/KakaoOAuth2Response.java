package dev.be.gptboard.dto.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class KakaoOAuth2Response {

    private final Long id;
    private final LocalDateTime connectedAt;
    private final Map<String, Object> properties;
    private final KakaoAccount kakaoAccount;

    public static KakaoOAuth2Response from(Map<String, Object> attributes) {
        return new KakaoOAuth2Response(
            Long.valueOf(String.valueOf(attributes.get("id"))),
            LocalDateTime.parse(
                String.valueOf(attributes.get("connected_at")),
                DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault())
            ),
            (Map<String, Object>) attributes.get("properties"),
            KakaoAccount.from((Map<String, Object>) attributes.get("kakao_account"))
        );
    }

    public String email() {
        return this.getKakaoAccount().getEmail();
    }
    public String nickname() {
        return this.getKakaoAccount().nickname();
    }
}
