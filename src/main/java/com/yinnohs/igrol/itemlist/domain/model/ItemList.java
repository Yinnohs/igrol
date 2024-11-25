package com.yinnohs.igrol.itemlist.domain.model;

import com.yinnohs.igrol.user.domain.model.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemList {

    private String id;
    private String title;
    private User listOwner;
    private List<Item> itemList;
    private List<User> participants;

    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    LocalDateTime deletedAt;
}
