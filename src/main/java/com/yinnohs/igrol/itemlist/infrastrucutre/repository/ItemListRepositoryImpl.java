package com.yinnohs.igrol.itemlist.infrastrucutre.repository;

import com.yinnohs.igrol.itemlist.domain.exception.IteListNotFoundException;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.domain.repository.ItemListRepository;
import com.yinnohs.igrol.itemlist.infrastrucutre.document.ItemListDocument;
import com.yinnohs.igrol.itemlist.infrastrucutre.mapper.ItemListMapper;
import com.yinnohs.igrol.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemListRepositoryImpl implements ItemListRepository {

    private final ItemListDocumentRepository repository;
    private final ItemListMapper mapper;

    @Override
    public ItemList save(ItemList itemList) {
        ItemListDocument document = mapper.fromDomainModel(itemList);
        ItemListDocument savedDocument =  repository.save(document);
        return mapper.toDomainModel(savedDocument);
    }

    @Override
    public List<ItemList> findItemListsByOwner(User owner) {
        List<ItemListDocument> documents = repository.findByListOwner(owner);
        return documents.stream().map(mapper::toDomainModel).toList();
    }

    @Override
    public ItemList findItemListById(String id) {
        ItemListDocument document = repository.findById(id)
                .orElseThrow(()-> new IteListNotFoundException("Could Not found item list with id: + id"));

        return mapper.toDomainModel(document);
    }

    @Override
    public void deleteItemListById(String id) {
        ItemListDocument document = repository.findById(id)
                .orElseThrow(()-> new IteListNotFoundException("Could Not found item list with id: + id"));
        repository.deleteById(id);
    }
}
