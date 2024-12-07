package com.yinnohs.igrol.itemlist.infrastrucutre.controller;

import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListUsesCasesImpl;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/itemlist")
public class ItemListController {

    private final ItemListUsesCasesImpl usesCases;


    @GetMapping("/users/{userId}")
    public ResponseEntity<?> findAllItemListOwnedByAnUser(@PathVariable("userId")String userId){
        return ResponseEntity.ok(usesCases.findOwnedItemListByAnUserUseCase(userId));
    }

    @GetMapping("/users/participants/{userId}")
    public ResponseEntity<?> findAllItemListCurrentParticipant(@PathVariable("userId")String userId){
        return ResponseEntity.ok(usesCases.findAllItemListWhereUserIsParticipant(userId));
    }

    @PostMapping
    public ResponseEntity<?> createNewItemList(@RequestBody CreateItemListRequest request){

        var itemList = ItemList.builder()
                .title(request.title())
                .listOwner(request.listOwner())
                .participants(request.participants())
                .build();

        return ResponseEntity.ok(usesCases.createNewItemList(itemList));
    }

    @PutMapping("/users")
    public  ResponseEntity<?> addNewParticipantToItemList(@RequestBody AddNewParticipantToListRequest request){
        return ResponseEntity.ok(usesCases.addNewParticipantToItemList(request.listId(), request.participantId()));
    }

    @PutMapping("/items")
    public  ResponseEntity<?> addAnItemToTheItemList(@RequestBody AddNewItemToListRequest request){
        return ResponseEntity.ok(usesCases.addAnItemToItemList(request.listId(), request.userId(), request.productId()));
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> softDeleteItemList(@PathVariable String listId){
        return ResponseEntity.ok(usesCases.softDeleteItemList(listId));
    }

    @PutMapping("/items/remove")
    public ResponseEntity<?> removeItemFromItemList(@RequestBody RemoveItemFromListRequest request){
        return  ResponseEntity.ok(usesCases.removeItemFromList(request.ItemId(), request.listId()));
    }

    @PutMapping("/items/bought")
    public ResponseEntity<?> markItemAsBought(@RequestBody MarkItemAsBoughtRequest request){
        return  ResponseEntity.ok(usesCases.markGivenItemAsBought(request.listId(), request.itemId()));
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteItemList(@PathVariable String listId){
        return  ResponseEntity.ok(usesCases.deleteItemList(listId));
    }

}
