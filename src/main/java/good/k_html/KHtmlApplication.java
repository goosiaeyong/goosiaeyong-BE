package good.k_html;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KHtmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(KHtmlApplication.class, args);
    }

}
