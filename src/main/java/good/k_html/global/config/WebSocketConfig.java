package good.k_html.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        // 클라이언트가 구독할 수 있는 메시지 브로커 경로 설정
        config.enableSimpleBroker("/topic");
        // 클라이언트가 메시지를 발행할 때 사용할 경로의 접두사 설정
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket STOMP 엔드포인트 설정
        registry.addEndpoint("/ws/chat") // 클라이언트가 WebSocket에 연결할 때 사용할 엔드포인트
                .setAllowedOrigins("*")  // CORS 설정
                .withSockJS();           // SockJS 지원
    }
}
