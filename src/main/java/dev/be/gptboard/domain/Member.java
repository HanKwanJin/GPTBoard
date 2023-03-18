package dev.be.gptboard.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
public class Member extends AuditingFields{

    @Id @Column(length = 50) private String id;

    @Setter @Column(length = 100) private String nickname;

    @Setter @Column(nullable = false) private String password;

    @Setter @Column(length = 100) private String email;

    public Member(String id, String nickname, String password, String email, String createdBy) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }

    public static Member of(String id, String nickname, String password, String email) {
        return new Member(id, nickname, password, email, null);
    }

    public static Member of(String id, String nickname, String password, String email, String createdBy) {
        return new Member(id, nickname, password, email, createdBy);
    }
}