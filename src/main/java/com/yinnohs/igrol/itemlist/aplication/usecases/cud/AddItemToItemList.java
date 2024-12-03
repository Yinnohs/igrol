package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;

public interface AddItemToItemList {
    ItemList addAnItemToItemList(String listId, String userId, String productId);
}
