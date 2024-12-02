package com.yinnohs.igrol.itemlist.aplication.usecases.impl;

import com.yinnohs.igrol.itemlist.aplication.usecases.cud.CudItemListUseCases;
import com.yinnohs.igrol.itemlist.aplication.usecases.read.ReadItemListWhereUserIsParticipantUseCases;
import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.domain.service.ItemListService;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ItemListWhereUserIsParticipantUsesCasesImpl implements CudItemListUseCases, ReadItemListWhereUserIsParticipantUseCases {

    private final ItemListService itemListService;
    private final UserService userService;

    @Override
    public ItemList addNewParticipantToItemList(String itemListId, String newParticipantId) {
        var newParticipant = userService.findBy("id", newParticipantId);
        var itemList = itemListService.findBy("id", itemListId);
        var participants = itemList.getParticipants();

        var isNewParticipant = participants.stream().anyMatch((user -> !user.getId().equals(newParticipantId)));

        if (isNewParticipant){
            participants.add(newParticipant);
            itemList.setParticipants(participants);
            return itemListService.updateList(itemList);
        }

        return itemList;
    }

    @Override
    public ItemList createNewItemList(ItemList itemList) {
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
                        item.setBoughtAt(LocalDateTime.now());
                        item.setBought(true);
                        return item;
                    }
                    return item;
                }).toList();
        itemList.setItems(items);

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
        var user = userService.findBy("id", userId);
        return itemListService.findAllUserOwnedItemLists(user);
    }

    @Override
    public ItemList addAnItemToItemList(String listId, Item itemToAdd) {
        var itemList = itemListService.findBy("id", listId);
        itemList.getItems().add(itemToAdd);
        return itemListService.updateList(itemList);
    }

    @Override
    public List<ItemList> findAllItemListWhereUserIsParticipant(String email) {
        User user = userService.findBy("email", email);
        return itemListService.findAllItemListWhereUserParticipate(user);
    }
}
