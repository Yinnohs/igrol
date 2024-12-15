package com.yinnohs.igrol.websocket.infrastructure.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.protocol.JacksonJsonSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yinnohs.igrol.json.jackson.module.LocalDateTimeIgrolJacksonModule;
import com.yinnohs.igrol.websocket.infrastructure.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SocketIOConfiguration {

    @Value("${socket.server.address}")
    private String address;

    @Value("${socket.server.port}")
    private Integer port;

    private final ConnectionService connectionService;
    private final ObjectMapper objectMapper;

    @Bean
    public SocketIOServer socketIOServerInit(){
        var config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(address);
        config.setPort(port);
        var localDateTimeModule = new LocalDateTimeIgrolJacksonModule();

        config.setJsonSupport(new JacksonJsonSupport(localDateTimeModule));

        var server = new SocketIOServer(config);
        server.addConnectListener(connectionService.onConnectMessage());
        server.addDisconnectListener(connectionService.onDisconnected());
        return  server;
    }
}
