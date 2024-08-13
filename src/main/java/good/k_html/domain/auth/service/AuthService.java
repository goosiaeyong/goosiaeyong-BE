package good.k_html.domain.auth.service;

import good.k_html.domain.user.entity.User;
import good.k_html.domain.user.repository.UserRepository;
import good.k_html.domain.auth.dto.request.AuthRequestDTO;
import good.k_html.domain.auth.dto.response.AuthResponseDTO;
import good.k_html.global.response.CustomException;
import good.k_html.global.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO signUser(AuthRequestDTO authRequestDTO) {

        if (!authRequestDTO.getPassword().equals(authRequestDTO.getPasswordConfirm())) {
            throw new CustomException(ErrorCode.NOT_EQUALS_PASSWORD);
        }
        if (userRepository.findByUserEmail(authRequestDTO.getUserEmail()).isPresent()) {
            throw new CustomException(ErrorCode.ALREADY_USER_EMAIL);
        }

        User user = new User();

        user.setUsername(authRequestDTO.getUsername());
        user.setUserEmail(authRequestDTO.getUserEmail());
        user.setAreaNM(authRequestDTO.getAreaNM());
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));

        userRepository.save(user);

        return new AuthResponseDTO(user);
    }
}
