package com.yinnohs.igrol.itemlist.infrastrucutre.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.infrastrucutre.config.WebSocketEndpointsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemListSocketService{

    private final WebSocketEndpointsConfig webSocketEndpointsConfig;

    public void sendItemListSocketEvent(SocketIOClient client, ItemList itemList) {
        client.sendEvent(webSocketEndpointsConfig.getItemListUpdateEndpoint(), itemList);
    }
}
