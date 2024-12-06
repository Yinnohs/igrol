package com.yinnohs.igrol.itemlist.infrastrucutre.controller;


import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListUsesCasesImpl;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.AddNewItemToListRequest;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.CreateItemListRequest;
import com.yinnohs.igrol.itemlist.infrastrucutre.dto.RemoveItemFromListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/itemlist")
public class ItemListController {

    private final ItemListUsesCasesImpl usesCases;

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

    @PutMapping("/items")
    public  ResponseEntity<?> addAnItemToTheItemList(@RequestBody AddNewItemToListRequest request){
        return ResponseEntity.ok(usesCases.addAnItemToItemList(request.listId(), request.userId(), request.productId()));
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> softDeleteItemList(@PathVariable String listId){
        return ResponseEntity.ok(usesCases.softDeleteItemList(listId));
    }

    @DeleteMapping("/items")
    public ResponseEntity<?> removeItemFromItemList(@RequestBody RemoveItemFromListRequest request){
        return  ResponseEntity.ok(usesCases.removeItemFromList(request.ItemId(), request.listId()));
    }

}
