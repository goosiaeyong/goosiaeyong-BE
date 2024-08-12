package good.k_html.domain.auth.dto.response;

import good.k_html.domain.user.entity.User;
import lombok.Getter;

@Getter
public class AuthResponseDTO {

    private Long userId;

    private String username;

    private String userEmail;

    public AuthResponseDTO(User user) {
        this.userEmail = user.getUserEmail();
        this.username = user.getUsername();
        this.userId = user.getUserId();
    }
}
