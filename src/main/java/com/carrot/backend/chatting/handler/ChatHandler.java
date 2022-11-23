package com.carrot.backend.chatting.handler;

import com.carrot.backend.chatting.domain.Chatting;
import com.carrot.backend.chatting.domain.ChattingRoom;
import com.carrot.backend.chatting.service.ChattingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Log4j2
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

    private final ChattingService chattingService;
    private final ObjectMapper objectMapper;

    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

    //    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        sessions.add(session);
    }

    /* Client가 접속 해제 시 호출되는 메서드드 */

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        log.info(session + " 클라이언트 접속 해제");
        sessions.remove(session);
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload);

//        https://dev-gorany.tistory.com/212
//        페이로드란 전송되는 데이터를 의미한다. 데이터를 전송할 때, Header와 META 데이터,
//        에러 체크 비트 등과 같은 다양한 요소들을 함께 보내 데이터 전송 효율과 안정성을 높히게 된다.
//        이때, 보내고자 하는 데이터 자체를 의미하는 것이 페이로드이다.예를 들어 택배 배송을
//        보내고 받을 때 택배 물건이 페이로드고 송장이나 박스 등은 부가적은 것이기 때문에 페이로드가 아니다.
        Chatting chatting = objectMapper.readValue(payload, Chatting.class);
        ChattingRoom room = chattingService.findById(chatting.getRoomId());
        room.handleActions(session,chatting,chattingService);
    }




}
