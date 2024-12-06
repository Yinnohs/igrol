package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;

public interface RemoveItemFromList {
    ItemList removeItemFromList(String itemId, String listId);
}
