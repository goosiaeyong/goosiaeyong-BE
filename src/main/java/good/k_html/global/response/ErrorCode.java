package good.k_html.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(400, "Bad request."),
    UNAUTHORIZED(401, "Unauthorized access."),
    FORBIDDEN(403, "Forbidden."),
    NOT_FOUND(404, "Resource not found."),
    INTERNAL_SERVER_ERROR(500, "Internal server error.");

    private final int status;

    private final String message;
}