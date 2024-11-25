package com.yinnohs.igrol.itemlist.domain.repository;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;

import java.util.List;

public interface ItemListRepository {
    public ItemList save(ItemList itemList);
    public List<ItemList> findItemListsByOwner(String ownerId);
    public ItemList findItemListById(String id);
    public void softDeleteItemListById(String id);
    public void deleteItemListById(String id);
}
