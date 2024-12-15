package com.yinnohs.igrol.itemlist.infrastrucutre.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class WebSocketEndpointsConfig {

    @Value("${socket.endpoint.list-updated}")
    private String itemListUpdateEndpoint;

    @Value("${socket.endpoint.add-item-to-item-list}")
    private String addItemToItemListEvent;
}
