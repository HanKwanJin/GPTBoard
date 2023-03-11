package dev.be.gptboard.repository;

import static org.assertj.core.api.Assertions.assertThat;

import dev.be.gptboard.config.JpaConfig;
import dev.be.gptboard.domain.Article;
import dev.be.gptboard.domain.Member;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
@DisplayName("JPA 연결 테스트")
class JpaRepositoryTest {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private ArticleCommentRepository articleCommentRepository;

    @Test
    @DisplayName("JPA - select 테스트")
    void givenTestData_whenSelecting_thenWorksFine() throws Exception {
        //given

        //when
        List<Article> result = articleRepository.findAll();
        //then
        assertThat(result)
            .isNotNull()
            .hasSize(3);
    }

    @Test
    @DisplayName("JPA - insert 테스트")
    void givenTestData_whenInserting_thenWorksFine() throws Exception {
        //given
        long previousCount = articleRepository.count();
        Member member = Member.of("hankwanjin", "password", "hankwanjin@email.com");
        memberRepository.save(member);

        //when
        Article article = Article.of(member, "test-title", "test-content");
        articleRepository.save(article);

        //then
        assertThat(articleRepository.count())
            .isEqualTo(previousCount + 1);
    }

    @Test
    @DisplayName("JPA - update 테스트")
    void givenTestData_whenUpdating_thenWorksFine() throws Exception {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();

        //when
        String targetStr = "modify-title";
        article.setTitle(targetStr);
        Article result = articleRepository.saveAndFlush(article);

        //then
        assertThat(result.getTitle())
            .isEqualTo(targetStr);
    }

    @Test
    @DisplayName("JPA - delete 테스트")
    void givenTestData_whenDeleting_thenWorksFine() throws Exception {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousCount = articleRepository.count();


        //when
        /*
         * 게시글을 지울 때 게시글과 관련된 댓글도 모두 지워줘야한다.
         */
        articleCommentRepository.deleteAll();
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count())
            .isEqualTo(previousCount - 1);
    }
}
