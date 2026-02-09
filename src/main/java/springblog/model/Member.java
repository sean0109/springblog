package springblog.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springblog.model.code.Role;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
public class Member implements UserDetails {

    private Long memberId;  // pk
    private String loginId;
    private String email;
    private String password;

    private Role role;  // 권한

    // 계정 만료 여부
    private String accountNonExpired;
    // 계정 잠금 여부
    private String accountNonLocked;
    // 비밀번호 만료 여부
    private String credentialsNonExpired;
    // 계정 사용 가능 여부
    private String enabled;

    @Builder
    public Member(String loginId, String email, String password) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    // 아이디를 반환으로 로직 변경
    @Override
    public String getUsername() {
        return loginId;
        //return userName;
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {

        return "Y".equals(accountNonExpired);
    }

    // 계정 잠금 여부
    @Override
    public boolean isAccountNonLocked() {
        return "Y".equals(accountNonLocked);
    }

    // 패스워드 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return "Y".equals(credentialsNonExpired);
    }

    // 계정 사용 가능 여부
    @Override
    public boolean isEnabled() {
        return "Y".equals(enabled);
    }
}
