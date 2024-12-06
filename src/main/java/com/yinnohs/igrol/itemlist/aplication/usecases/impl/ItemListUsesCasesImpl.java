package com.yinnohs.igrol.itemlist.aplication.usecases.impl;

import com.yinnohs.igrol.itemlist.aplication.usecases.cud.CudItemListUseCases;
import com.yinnohs.igrol.itemlist.aplication.usecases.read.ReadItemListWhereUserIsParticipantUseCases;
import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.domain.service.ItemListService;
import com.yinnohs.igrol.product.domain.service.ProductService;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ItemListUsesCasesImpl implements CudItemListUseCases, ReadItemListWhereUserIsParticipantUseCases {

    private final ItemListService itemListService;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public ItemList addNewParticipantToItemList(String itemListId, String newParticipantId) {
        var newParticipant = userService.findBy("id", newParticipantId);
        var itemList = itemListService.findBy("id", itemListId);
        var participants = itemList.getParticipants();

        var isNewParticipant = participants.stream().anyMatch((user -> !user.getId().equals(newParticipantId)));

        if (isNewParticipant){
            participants.add(newParticipant);
            itemList.setParticipants(participants);
            itemList.setLastUpdate(LocalDateTime.now());
            return itemListService.updateList(itemList);
        }

        return itemList;
    }

    @Override
    public ItemList createNewItemList(ItemList itemList) {
        var now = LocalDateTime.now();
        itemList.setItems(new ArrayList<>());
        itemList.setCreatedAt(now);
        itemList.setLastUpdate(now);
        return itemListService.createNewList(itemList);
    }

    @Override
    public Void deleteItemList(String itemList) {
        itemListService.deleteItemListById(itemList);
        return null;
    }

    @Override
    public ItemList markGivenItemAsBought(String listId, String itemId) {
        var itemList = itemListService.findBy("id", listId);
        var items = itemList
                .getItems()
                .stream()
                .map((item)-> {
                    if(item.getId().equals(itemId)){
                        var now = LocalDateTime.now();
                        item.setBought(true);
                        item.setBoughtAt(now);
                        item.setLastUpdate(now);
                        return item;
                    }
                    return item;
                }).toList();

        itemList.setItems(items);
        itemList.setLastUpdate(LocalDateTime.now());
        return itemListService.updateList(itemList);
    }

    @Override
    public ItemList softDeleteItemList(String itemListId) {
        var itemList = itemListService.findBy("id", itemListId);
        itemList.setDeletedAt(LocalDateTime.now());
        return itemListService.updateList(itemList);
    }

    @Override
    public List<ItemList> findOwnedItemListByAnUserUseCase(String userId) {
        return itemListService.findAllUserOwnedItemLists(userId);
    }

    @Override
    public ItemList addAnItemToItemList(String listId, String userId, String productId) {
        var product = productService.findBy("id", productId);
        var user = userService.findBy("id", userId);
        var itemList = itemListService.findBy("id", listId);
        var now = LocalDateTime.now();

        Item itemToAdd = Item.builder()
                .id(UUID.randomUUID().toString())
                .addedBy(user)
                .product(product)
                .createdAt(now)
                .lastUpdate(now)
                .isBought(false)
                .boughtAt(null)
                .build();

        itemList.getItems().add(itemToAdd);
        itemList.setLastUpdate(LocalDateTime.now());
        return itemListService.updateList(itemList);
    }

    @Override
    public List<ItemList> findAllItemListWhereUserIsParticipant(String userId) {
        return itemListService.findAllItemListWhereUserParticipate(userId);
    }

    @Override
    public ItemList removeItemFromList(String itemId, String listId) {
        var itemList = itemListService.findBy("id", listId);
        var updatedItemList = itemList.getItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .toList();

        itemList.setItems(updatedItemList);
        itemList.setLastUpdate(LocalDateTime.now());
        return itemListService.updateList(itemList);
    }
}
