package com.yinnohs.igrol.itemlist.infrastrucutre.dto;

public record AddNewItemToListRequest(
        String listId,
        String userId,
        String productId
) {
}
