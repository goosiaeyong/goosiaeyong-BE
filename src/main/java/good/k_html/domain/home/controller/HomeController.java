package good.k_html.domain.home.controller;

import good.k_html.global.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<ApiResponse<Void>> HealthCheck(){

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of("home",null));
    }
}
