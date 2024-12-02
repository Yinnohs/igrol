package com.yinnohs.igrol.itemlist.aplication.usecases.read;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;


import java.util.List;

public interface FindOwnedItemListByAnUser {
    List<ItemList> findOwnedItemListByAnUserUseCase(String userId);
}
