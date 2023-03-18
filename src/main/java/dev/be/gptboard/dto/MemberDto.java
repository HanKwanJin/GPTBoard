package dev.be.gptboard.dto;

import dev.be.gptboard.domain.AuditingFields;
import dev.be.gptboard.domain.Member;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberDto{
    private final String memberId;
    private final String memberPassword;
    private final String email;
    private final String nickname;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static MemberDto of(String memberId, String memberPassword, String email, String nickname, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new MemberDto(memberId, memberPassword, email, nickname, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static MemberDto of(String memberId, String memberPassword, String email, String nickname) {
        return new MemberDto(memberId, memberPassword, email, nickname, null, null, null, null);
    }

    public static MemberDto from(Member member) {
        return new MemberDto(
            member.getId(),
            member.getPassword(),
            member.getEmail(),
            member.getNickname(),
            member.getCreatedAt(),
            member.getCreatedBy(),
            member.getModifiedAt(),
            member.getModifiedBy()
        );
    }
}
