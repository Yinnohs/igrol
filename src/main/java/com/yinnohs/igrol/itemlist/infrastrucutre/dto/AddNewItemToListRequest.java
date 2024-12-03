package com.yinnohs.igrol.itemlist.infrastrucutre.dto;

public record AddNewItemToListRequest(
        String itemListId,
        String userId,
        String productId
) {
}
