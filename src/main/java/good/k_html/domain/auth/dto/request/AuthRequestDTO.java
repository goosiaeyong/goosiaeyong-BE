package good.k_html.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class AuthRequestDTO {

    @NotBlank
    private String username;

    @NotBlank
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String userEmail;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "비밀번호는 최소 8자 이상이며, 영문자와 숫자를 포함해야 합니다."
    )
    private String password;

    @NotBlank
    private String passwordConfirm;
}
