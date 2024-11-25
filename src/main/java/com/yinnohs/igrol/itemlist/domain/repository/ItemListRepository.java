package com.yinnohs.igrol.itemlist.domain.repository;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;

public interface ItemListRepository {
    public ItemList save(ItemList itemList);
    public List<ItemList> findItemListsByOwner(User owner);
    public ItemList findItemListById(String id);
    public void deleteItemListById(String id);
}
