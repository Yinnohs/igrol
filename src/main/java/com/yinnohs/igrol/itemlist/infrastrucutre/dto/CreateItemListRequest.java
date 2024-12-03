package com.yinnohs.igrol.itemlist.infrastrucutre.dto;

import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

public record CreateItemListRequest(
        String title,
        User listOwner,
        List<User> participants
) {
}
