package good.k_html.global.jwt;

import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtil {

    @Value("${JWT_SECRET_KEY}") // Base64 Encode 한 SecretKey
    private String secret;

    // JWT 생성
    public String createToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 6)) // 6시간 유효
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // JWT를 쿠키에 저장하고 응답 헤더에 추가
    public void addJwtToCookie(String token, HttpServletResponse response) {
        try {
            token = URLEncoder.encode(token, "utf-8").replaceAll("\\+", "%20");

            // 쿠키 생성 및 설정
            Cookie cookie = new Cookie("Authorization", token);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 6); // 쿠키의 만료 시간 설정 (6시간)

            // 응답 헤더에 쿠키 추가
            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
    }

    // JWT 토큰 substring
    public String substringToken(String tokenValue) {

        if (StringUtils.hasText(tokenValue) && tokenValue.startsWith("Bearer ")) {
            return tokenValue.substring(7);
        }

        throw new NullPointerException("토큰을 찾을 수 없습니다.");
    }

    // 토큰에서 사용자 정보 가져오기
    public Claims getUserInfoFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    // 토큰 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
            return true;

        } catch (SecurityException | MalformedJwtException | SignatureException e) {
            log.error("유효하지 않는 JWT 서명 입니다.");
        } catch (ExpiredJwtException e) {
            log.error("만료된 JWT token 입니다.");
        } catch (UnsupportedJwtException e) {
            log.error("지원되지 않는 JWT 토큰 입니다.");
        } catch (IllegalArgumentException e) {
            log.error("잘못된 JWT 토큰 입니다.");
        }
        return false;
    }
}