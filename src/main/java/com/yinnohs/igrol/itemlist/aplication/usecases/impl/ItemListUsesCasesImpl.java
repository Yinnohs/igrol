package com.yinnohs.igrol.itemlist.aplication.usecases.impl;

import com.yinnohs.igrol.itemlist.aplication.usecases.cud.CudItemListUseCases;
import com.yinnohs.igrol.itemlist.aplication.usecases.read.ReadItemListUseCases;
import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;

public class ItemListUsesCasesImpl implements CudItemListUseCases, ReadItemListUseCases {
    @Override
    public List<ItemList> addAnItemToItemList(String listId, Item itemToAdd) {
        return List.of();
    }

    @Override
    public ItemList addNewParticipantToItemList(String itemList, User newParticipant) {
        return null;
    }

    @Override
    public ItemList createNewItemList(ItemList itemList) {
        return null;
    }

    @Override
    public Void deleteItemList(String itemList) {
        return null;
    }

    @Override
    public ItemList markGivenItemAsBought(String listId, String itemId) {
        return null;
    }

    @Override
    public ItemList softDeleteItemList(String itemList) {
        return null;
    }

    @Override
    public List<ItemList> findAllItemList() {
        return List.of();
    }

    @Override
    public List<ItemList> findOwnedItemListByAnUserUseCase(User user) {
        return List.of();
    }
}
