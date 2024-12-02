package com.yinnohs.igrol.itemlist.infrastrucutre.controller;


import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListWhereUserIsParticipantUsesCasesImpl;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/itemlist")
public class ItemListController {

    private final ItemListWhereUserIsParticipantUsesCasesImpl usesCases;

    @PostMapping
    public ResponseEntity<?> createNewItemList(ItemList itemList){
        return ResponseEntity.ok(usesCases.createNewItemList(itemList));
    }

}
