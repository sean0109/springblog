package springblog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
public class MemberForm {

    @NotEmpty(message = "회원 아이디는 필수 입니다.")
    private String loginId;
    @NotEmpty(message = "이메일은 필수 입니다.")
    private String email;
    @NotEmpty(message = "비밀번호를 입력해 주세요")
    private String password;

    @Builder
    public MemberForm(String loginId, String email, String password) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
    }
}
