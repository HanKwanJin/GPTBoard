package dev.be.gptboard.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
public class Article extends AuditingFields{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @Setter @Column(nullable = false) private String title;

    @Setter @Column(nullable = false, length = 10000) private String content;

    public Article(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
}
