package springblog.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class memberForm {

    private String loginId;
    private String email;
    private String password;

    @Builder
    public memberForm(String loginId, String email, String password) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
    }
}
