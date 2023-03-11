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
public class ArticleComment extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne private Article article;

    @Setter @ManyToOne private Member member;

    @Setter @Column(updatable = false) private Long parentCommentId;

    @Setter @Column(nullable = false, length = 500) private String content;

    public ArticleComment(Article article, Member member, Long parentCommentId, String content) {
        this.article = article;
        this.member = member;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }

    public static ArticleComment of(Article article, Member member, String content) {
        /* 처음 생성한 댓글은 부모 댓글이 없다. */
        return new ArticleComment(article, member, null, content);
    }
}
