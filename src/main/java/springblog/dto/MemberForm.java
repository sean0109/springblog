package springblog.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class MemberForm {

    private String loginId;
    private String email;
    private String password;

    @Builder
    public MemberForm(String loginId, String email, String password) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
    }
}
