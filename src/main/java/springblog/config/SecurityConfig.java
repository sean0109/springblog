package springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 설정 클래스
 * - 어떤 URL을 누가 접근할 수 있는지 정의
 * - 로그인/로그아웃 처리 방식 설정
 * - 비밀번호 암호화 방식 설정
 */
@Configuration  // Spring 설정 클래스임을 표시
@EnableWebSecurity  // Spring Security 활성화
public class SecurityConfig {

    /**
     * SecurityFilterChain: Spring Security의 핵심
     * - 모든 HTTP 요청은 이 필터 체인을 거침
     * - 여기서 정의한 규칙에 따라 접근 허용/거부 결정
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 개발 중에는 모든 요청 허용 (나중에 로그인 구현 시 수정)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // CSRF 비활성화
                .csrf(csrf -> csrf.disable())
                .build();
    }

    /**
     * PasswordEncoder: 비밀번호 암호화 방식 설정
     * - BCrypt: 단방향 해시 알고리즘 (복호화 불가능)
     * - 회원가입 시: 평문 비밀번호를 BCrypt로 암호화하여 DB 저장
     * - 로그인 시: 입력한 비밀번호를 암호화하여 DB의 암호화된 비밀번호와 비교
     *
     * 예시:
     * - 입력: "1234"
     * - 저장: "$2a$10$X5wFuQoXe1/oY8H8K0f1qO8..." (매번 다른 값)
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
}
