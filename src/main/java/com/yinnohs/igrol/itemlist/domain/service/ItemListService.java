package com.yinnohs.igrol.itemlist.domain.service;

import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;

public interface ItemListService {
    public ItemList createNewList(ItemList itemList);
    public List<ItemList> findAllMyItemList(String userId);
    public ItemList findBy(String type, String value);
    public ItemList addNewItem(String listId, Item newItem);
    public ItemList changeItemListTitle(String listId, String newTitle);
    public ItemList addNewParticipant(String listId, User user);
}
