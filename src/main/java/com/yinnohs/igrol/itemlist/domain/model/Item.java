package com.yinnohs.igrol.itemlist.domain.model;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.user.domain.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    private String id;
    private Product product;
    private boolean isBought;
    private User addedBy;

    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    LocalDateTime boughtAt;
    LocalDateTime
}
