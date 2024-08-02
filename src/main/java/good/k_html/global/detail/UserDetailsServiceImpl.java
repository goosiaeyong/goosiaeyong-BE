package good.k_html.global.detail;

import good.k_html.domain.User.entity.User;
import good.k_html.domain.User.repository.UserRepository;
import good.k_html.global.response.CustomException;
import good.k_html.global.response.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        return new UserDetailsImpl(user);
    }
}