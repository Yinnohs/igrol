package com.yinnohs.igrol.itemlist.infrastrucutre.controller;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListUseCases;
import com.yinnohs.igrol.itemlist.infrastrucutre.config.WebSocketEndpointsConfig;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.AddNewItemToListRequest;
import com.yinnohs.igrol.itemlist.infrastrucutre.service.ItemListSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ItemListWebSocketController {

    private  SocketIOServer server;
    private final ItemListSocketService socketService;
    private final ItemListUseCases useCases;
    private final WebSocketEndpointsConfig webSocketEndpointsConfig;


    public ItemListWebSocketController(SocketIOServer server,
                                       ItemListSocketService socketService,
                                       ItemListUseCases itemListUseCases,
                                       WebSocketEndpointsConfig webSocketEndpointsConfig){
        this.server = server;
        this.socketService = socketService;
        this.useCases = itemListUseCases;
        this.webSocketEndpointsConfig = webSocketEndpointsConfig;
        server.addEventListener(
                webSocketEndpointsConfig.getAddItemToItemListEvent(),
                AddNewItemToListRequest.class,
                onItemListUpdate());
    }

    private DataListener<AddNewItemToListRequest> onItemListUpdate(){
        return (client, request, ackSender) ->{
            var itemList = useCases.addAnItemToItemList(request.listId(), request.userId(), request.productId());
            socketService.sendItemListSocketEvent(client,itemList);
        };
    }
}
