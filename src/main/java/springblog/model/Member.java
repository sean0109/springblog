package springblog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import springblog.dto.MemberForm;
import springblog.model.code.Role;

import java.time.LocalDateTime;
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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 계정 만료 여부
    private String accountNonExpired;
    // 계정 잠금 여부
    private String accountNonLocked;
    // 비밀번호 만료 여부
    private String credentialsNonExpired;
    // 계정 사용 가능 여부
    private String enabled;

    @Builder
    public Member (String loginId, String email, String password, Role role,
                   String accountNonExpired, String accountNonLocked, String credentialsNonExpired,
                   String enabled) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    // 정적 팩토리 메서드 추가
    public static Member createNewMember(MemberForm form, PasswordEncoder encoder) {
        return Member.builder()
                .loginId(form.getLoginId())
                .email(form.getEmail())
                .password(encoder.encode(form.getPassword()))
                .role(Role.USER)
                .accountNonExpired("Y")
                .accountNonLocked("Y")
                .credentialsNonExpired("Y")
                .enabled("Y")
                .build();
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
