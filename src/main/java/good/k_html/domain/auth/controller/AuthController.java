package good.k_html.domain.auth.controller;

import good.k_html.domain.auth.dto.request.AuthRequestDTO;
import good.k_html.domain.auth.dto.response.AuthResponseDTO;
import good.k_html.domain.auth.service.AuthService;
import good.k_html.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auths")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> signUser(
            @RequestBody AuthRequestDTO authRequestDTO){

        AuthResponseDTO authResponseDTO = authService.signUser();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.of("유저 회원가입 성공", authResponseDTO));
    }

}
