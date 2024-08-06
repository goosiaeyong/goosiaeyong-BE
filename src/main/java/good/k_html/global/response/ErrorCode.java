package good.k_html.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //공통
    NOT_FOUND(404, "Resource not found."),
    BAD_REQUEST(400, "Bad request."),
    UNAUTHORIZED(401, "Unauthorized access."),
    FORBIDDEN(403, "Forbidden."),
    INTERNAL_SERVER_ERROR(500, "Internal server error."),

    //auth
    NOT_EQUALS_PASSWORD(400, "비밀번호가 일치하지 않습니다."),
    ALREADY_USER_EMAIL(400, "이미 있는 이메일 입니다.");

    private final int status;

    private final String message;
}