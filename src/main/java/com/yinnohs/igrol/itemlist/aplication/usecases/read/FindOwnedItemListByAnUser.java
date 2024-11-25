package com.yinnohs.igrol.itemlist.aplication.usecases.read;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;

public interface FindOwnedItemListByAnUser {
    List<ItemList> findOwnedItemListByAnUserUseCase(User user);
}
