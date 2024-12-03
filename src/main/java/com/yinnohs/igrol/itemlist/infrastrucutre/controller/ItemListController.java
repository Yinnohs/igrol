package com.yinnohs.igrol.itemlist.infrastrucutre.controller;


import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListWhereUserIsParticipantUsesCasesImpl;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.CreateItemListRequest;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/itemlist")
public class ItemListController {

    private final ItemListWhereUserIsParticipantUsesCasesImpl usesCases;

    @PostMapping
    public ResponseEntity<?> createNewItemList(@RequestBody CreateItemListRequest request){

        var itemList = ItemList.builder()
                .title(request.title())
                .listOwner(request.listOwner())
                .participants(request.participants())
                .build();

        return ResponseEntity.ok(usesCases.createNewItemList(itemList));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findAllItemListOwnedByAnUser(@PathVariable("userId")String userId){
        return ResponseEntity.ok(usesCases.findOwnedItemListByAnUserUseCase(userId));
    }

}
