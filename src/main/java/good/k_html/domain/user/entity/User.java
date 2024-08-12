package good.k_html.domain.user.entity;

import good.k_html.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Setter
    private String username;

    @Setter
    @Column(unique = true)
    private String userEmail;

    @Setter
    private String password;
}
