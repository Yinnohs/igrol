package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;

import java.util.List;

public interface CreateNewItemList {
    ItemList createNewItemList(ItemList itemList, String ownerId, List<String> participantsId);
}
