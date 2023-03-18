package dev.be.gptboard.dto.security;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class KakaoAccount {

    private final Boolean profileNicknameNeedsAgreement;
    private final Profile profile;
    private final Boolean hasEmail;
    private final Boolean emailNeedsAgreement;
    private final Boolean isEmailValid;
    private final Boolean isEmailVerified;
    private final String email;

    public static KakaoAccount from(Map<String, Object> attributes) {
        return builder()
            .profileNicknameNeedsAgreement(Boolean.valueOf(String.valueOf(attributes.get("profile_nickname_needs_agreement"))))
            .profile(Profile.from((Map<String, Object>) attributes.get("profile")))
            .hasEmail(Boolean.valueOf(String.valueOf(attributes.get("has_email"))))
            .emailNeedsAgreement(Boolean.valueOf(String.valueOf(attributes.get("email_needs_agreement"))))
            .isEmailValid(Boolean.valueOf(String.valueOf(attributes.get("is_email_valid"))))
            .isEmailVerified(Boolean.valueOf(String.valueOf(attributes.get("is_email_verified"))))
            .email(String.valueOf(attributes.get("email")))
            .build();
    }

    public String nickname() {
        return this.profile.getNickname();
    }
}
