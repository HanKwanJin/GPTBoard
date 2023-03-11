package dev.be.gptboard.repository;

import dev.be.gptboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
