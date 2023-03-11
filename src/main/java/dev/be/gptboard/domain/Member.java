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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(length = 100) private String nickname;

    @Setter @Column(nullable = false) private String password;

    @Setter @Column(length = 100) private String email;

    public Member(String nickname, String password, String email) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public static Member of(String nickname, String password, String email) {
        return new Member(nickname, password, email);
    }
}