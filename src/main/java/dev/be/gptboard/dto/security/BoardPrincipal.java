package dev.be.gptboard.dto.security;

import dev.be.gptboard.dto.MemberDto;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
@RequiredArgsConstructor
public class BoardPrincipal implements UserDetails, OAuth2User {
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String email;
    private final String nickname;
    private final Map<String, Object> oAuth2Attributes;


    public static BoardPrincipal of(String username, String password, String email, String nickname) {
        return of(username, password, email, nickname, Map.of());
    }

    public static BoardPrincipal of(String username, String password, String email, String nickname, Map<String, Object> oAuth2Attributes) {

        Set<RoleType> roleTypes = Set.of(RoleType.USER);

        return new BoardPrincipal(
            username,
            password,
            roleTypes.stream()
                .map(RoleType::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableSet()),
            email,
            nickname,
            oAuth2Attributes
        );
    }

    public static BoardPrincipal from(MemberDto dto) {
        return BoardPrincipal.of(
            dto.getMemberId(),
            dto.getMemberPassword(),
            dto.getEmail(),
            dto.getNickname()
        );
    }

    public MemberDto toDto() {
        return MemberDto.of(
            username,
            password,
            email,
            nickname
        );
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override public String getPassword() {
        return password;
    }
    @Override public String getUsername() {
        return username;
    }
    @Override public boolean isAccountNonExpired() {
        return true;
    }
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override public boolean isEnabled() {
        return true;
    }

    @Override public String getName() { return username; }
    @Override public Map<String, Object> getAttributes() { return oAuth2Attributes; }
    public enum RoleType {
        USER("ROLE_USER");

        @Getter
        private final String name;

        RoleType(String name) {
            this.name = name;
        }
    }
}
