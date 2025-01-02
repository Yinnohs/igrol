package com.yinnohs.igrol.itemlist.domain.ports.in;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;

import java.util.List;

public interface ItemListService {
    public ItemList createNewList(ItemList itemList);
    public List<ItemList> findAllUserOwnedItemLists(String userId);
    public ItemList findBy(String type, String value);
    public void deleteItemListById(String listId);
    public List<ItemList> findAllItemListWhereUserParticipate(String userId);
    public ItemList updateList(ItemList itemListToUpdate);
}
