package dev.be.gptboard.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import dev.be.gptboard.domain.ArticleComment;
import dev.be.gptboard.domain.QArticleComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;


public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

}
