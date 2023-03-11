package dev.be.gptboard.repository;

import dev.be.gptboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
