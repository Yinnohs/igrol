package com.yinnohs.igrol.itemlist.domain.service;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;

public interface ItemListService {
    public ItemList createNewList(ItemList itemList);
    public List<ItemList> findAllUserOwnedItemLists(User user);
    public ItemList findBy(String type, String value);
    public void deleteItemListById(String listId);
    public List<ItemList> findAllItemListWhereUserParticipate(User user);
    public ItemList updateList(ItemList itemListToUpdate);
}
