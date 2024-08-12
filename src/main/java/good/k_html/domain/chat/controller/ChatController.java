package good.k_html.domain.chat.controller;

import good.k_html.domain.chat.dto.ChatMassage;
import good.k_html.domain.chat.dto.ChatRequestDTO;
import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("api/chats")
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping("/texttotext")
    public void textToText(
            @RequestBody ChatRequestDTO requestDTO,
            @RequestParam(name = "file") MultipartFile file) {

        //Todo: 해당 파일 ai 로 웹플럭스로 호출 응답값 받아오고 sendMessage 사용해서 응답값 발행할 것
    }

    @MessageMapping("/sendMessage/{userId}")
    public void sendMessage(@DestinationVariable String userId, ChatMassage message) {
        // 특정 채팅방으로 메시지 브로드캐스트
        messagingTemplate.convertAndSend("/topic/chatRoom/" + userId, message);
    }
}
