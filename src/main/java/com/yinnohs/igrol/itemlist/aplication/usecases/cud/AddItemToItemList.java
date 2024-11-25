package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;

import java.util.List;

public interface AddItemToItemList {
    List<ItemList> addAnItemToItemList(String listId, Item itemToAdd);
}
