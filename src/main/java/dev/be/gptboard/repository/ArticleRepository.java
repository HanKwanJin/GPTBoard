package dev.be.gptboard.repository;

import dev.be.gptboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
