package springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // 하드코딩된 게시글 데이터
        List<Map<String, Object>> posts = List.of(
                Map.of(
                        "id", 1,
                        "title", "Spring Boot로 블로그 만들기 - 시작편",
                        "excerpt", "Spring Boot와 Thymeleaf를 사용하여 블로그를 만드는 과정을 소개합니다. MyBatis와 Oracle DB를 연동하여...",
                        "thumbnail", "https://picsum.photos/seed/spring/400/250",
                        "category", "개발",
                        "date", LocalDate.of(2024, 1, 15),
                        "commentCount", 12
                ),
                Map.of(
                        "id", 2,
                        "title", "MyBatis 완벽 가이드",
                        "excerpt", "MyBatis를 활용한 효율적인 데이터베이스 접근 방법을 알아봅니다. Mapper XML 작성부터 동적 쿼리까지...",
                        "thumbnail", "https://picsum.photos/seed/mybatis/400/250",
                        "category", "데이터베이스",
                        "date", LocalDate.of(2024, 1, 20),
                        "commentCount", 8
                ),
                Map.of(
                        "id", 3,
                        "title", "Spring Security 인증과 인가",
                        "excerpt", "Spring Security의 핵심 개념인 인증과 인가에 대해 알아봅니다. SecurityFilterChain 설정 방법과...",
                        "thumbnail", "https://picsum.photos/seed/security/400/250",
                        "category", "보안",
                        "date", LocalDate.of(2024, 1, 25),
                        "commentCount", 15
                ),
                Map.of(
                        "id", 4,
                        "title", "Oracle Database 설치와 설정",
                        "excerpt", "Docker를 이용한 Oracle Database 설치와 기본 설정을 다룹니다. PDB 생성부터 사용자 권한까지...",
                        "thumbnail", "https://picsum.photos/seed/oracle/400/250",
                        "category", "데이터베이스",
                        "date", LocalDate.of(2024, 1, 28),
                        "commentCount", 5
                ),
                Map.of(
                        "id", 5,
                        "title", "Thymeleaf 템플릿 엔진 활용하기",
                        "excerpt", "Thymeleaf의 강력한 기능들을 활용하여 동적인 웹 페이지를 만드는 방법을 소개합니다. 레이아웃 구성부터...",
                        "thumbnail", "https://picsum.photos/seed/thymeleaf/400/250",
                        "category", "프론트엔드",
                        "date", LocalDate.of(2024, 2, 1),
                        "commentCount", 7
                ),
                Map.of(
                        "id", 6,
                        "title", "RESTful API 설계 원칙",
                        "excerpt", "REST API의 기본 원칙과 Spring Boot에서의 구현 방법을 알아봅니다. HTTP 메서드 활용과 상태 코드...",
                        "thumbnail", "https://picsum.photos/seed/restapi/400/250",
                        "category", "API",
                        "date", LocalDate.of(2024, 2, 5),
                        "commentCount", 10
                )
        );

        // 태그 목록
        List<Map<String, Object>> tags = List.of(
                Map.of("name", "Spring Boot", "count", 15),
                Map.of("name", "Java", "count", 12),
                Map.of("name", "MyBatis", "count", 8),
                Map.of("name", "Oracle", "count", 6),
                Map.of("name", "Security", "count", 9),
                Map.of("name", "Thymeleaf", "count", 7),
                Map.of("name", "REST API", "count", 11),
                Map.of("name", "Database", "count", 14),
                Map.of("name", "Web Development", "count", 10),
                Map.of("name", "Backend", "count", 13)
        );

        // 공지사항
        List<String> announcements = List.of(
                "블로그 오픈을 환영합니다!",
                "회원가입 후 자유롭게 글을 작성해주세요.",
                "서로 존중하는 댓글 문화를 만들어가요."
        );

        model.addAttribute("posts", posts);
        model.addAttribute("tags", tags);
        model.addAttribute("announcements", announcements);

        return "home";
    }
}
