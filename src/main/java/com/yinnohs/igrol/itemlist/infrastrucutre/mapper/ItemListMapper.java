package com.yinnohs.igrol.itemlist.infrastrucutre.mapper;

import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.infrastrucutre.document.ItemListDocument;
import org.springframework.stereotype.Service;

@Service
public class ItemListMapper {

    public ItemListDocument fromDomainModel(ItemList itemList){
        return ItemListDocument.builder()
                .id(itemList.getId())
                .title(itemList.getTitle())
                .listOwner(itemList.getListOwner())
                .participants(itemList.getParticipants())
                .items(itemList.getItems())
                .createdAt(itemList.getCreatedAt())
                .lastUpdate(itemList.getLastUpdate())
                .deletedAt(itemList.getDeletedAt())
                .build();
    }

    public ItemList toDomainModel(ItemListDocument itemList){
        return ItemList.builder()
                .id(itemList.getId())
                .title(itemList.getTitle())
                .listOwner(itemList.getListOwner())
                .participants(itemList.getParticipants())
                .items(itemList.getItems())
                .createdAt(itemList.getCreatedAt())
                .lastUpdate(itemList.getLastUpdate())
                .deletedAt(itemList.getDeletedAt())
                .build();
    }
}
