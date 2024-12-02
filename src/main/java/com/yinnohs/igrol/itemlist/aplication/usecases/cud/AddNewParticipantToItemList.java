package com.yinnohs.igrol.itemlist.aplication.usecases.cud;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.user.domain.model.User;

public interface AddNewParticipantToItemList {
    ItemList addNewParticipantToItemList(String itemList , String newParticipantId);
}
