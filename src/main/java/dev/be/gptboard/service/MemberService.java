package dev.be.gptboard.service;

import dev.be.gptboard.domain.Member;
import dev.be.gptboard.dto.MemberDto;
import dev.be.gptboard.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<MemberDto> searchMember(String username) {
        return memberRepository.findById(username)
            .map(MemberDto::from);
    }

    @Transactional
    public MemberDto saveMember(String username, String password, String email, String nickname) {
        return MemberDto.from(
            memberRepository.save(Member.of(username, nickname, password,email))
        );
    }
}
