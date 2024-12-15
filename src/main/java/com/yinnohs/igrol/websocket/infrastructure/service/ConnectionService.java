package com.yinnohs.igrol.websocket.infrastructure.service;

import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class ConnectionService {

    public ConnectListener onConnectMessage(){
        return (client)->{
            var params = client.getHandshakeData().getUrlParams();
            String room = String.join("", params.get("listId"));
            client.joinRoom(room);
            log.info("Socket connect with id [{}] - itemlist with id [{}]", client.getSessionId().toString(), room);
        };
    }

    public DisconnectListener onDisconnected() {
        return client -> {
            var params = client.getHandshakeData().getUrlParams();
            if (params != null) {
                String room = String.join("", params.get("listId"));
                log.info("Socket user with socket id [{}]  has disconnected ", client.getSessionId().toString(), room);
            }
        };
    }
}
