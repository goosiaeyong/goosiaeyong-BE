package good.k_html.domain.auth.repository;

import good.k_html.domain.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
