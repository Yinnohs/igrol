package com.yinnohs.igrol.itemlist.infrastrucutre.document;

import com.yinnohs.igrol.itemlist.domain.model.Item;
import com.yinnohs.igrol.user.domain.model.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("itemList")
public class ItemListDocument {

    @Id
    private String id;
    private String title;
    private User listOwner;
    private List<Item> items;
    private List<User> participants;
    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    LocalDateTime deletedAt;


}

