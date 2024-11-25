package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;

public interface MarkGivenItemAsBought {
    ItemList markGivenItemAsBought(String listId, String itemId);
}
