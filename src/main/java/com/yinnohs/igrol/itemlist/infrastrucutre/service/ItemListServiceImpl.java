package com.yinnohs.igrol.itemlist.infrastrucutre.service;

import com.yinnohs.igrol.itemlist.domain.exception.IteListNotFoundException;
import com.yinnohs.igrol.itemlist.domain.model.ItemList;
import com.yinnohs.igrol.itemlist.domain.service.ItemListService;
import com.yinnohs.igrol.itemlist.infrastrucutre.document.ItemListDocument;
import com.yinnohs.igrol.itemlist.infrastrucutre.mapper.ItemListMapper;
import com.yinnohs.igrol.itemlist.infrastrucutre.repository.ItemListDocumentRepository;
import com.yinnohs.igrol.shared.exception.NotSupportedFindType;
import com.yinnohs.igrol.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemListServiceImpl implements ItemListService {

    private final ItemListDocumentRepository repository;
    private final ItemListMapper mapper;

    private final String FIND_BY_TITLE = "title";
    private final String FIND_BY_ID = "id";

    @Override
    public ItemList createNewList(ItemList itemList) {
        var createdList = repository.save(mapper.fromDomainModel(itemList));
        return mapper.toDomainModel(createdList);
    }

    @Override
    public List<ItemList> findAllUserOwnedItemLists(String userId) {
        return repository
                .findByListOwner(userId)
                .stream()
                .map(mapper::toDomainModel)
                .toList();
    }

    @Override
    public ItemList findBy(String type, String value) {

        if (FIND_BY_ID.equals(type)) {
            ItemListDocument document = repository
                    .findById(value)
                    .orElseThrow(()-> new IteListNotFoundException("Could Not found item list with id: + id"));
            return mapper.toDomainModel(document);
        }

        if (FIND_BY_TITLE.equals(type)){
            ItemListDocument document = repository
                    .findByTitle(value)
                    .orElseThrow(()-> new IteListNotFoundException("Could Not found item list with id: + id"));

            return mapper.toDomainModel(document);
        }

        throw new NotSupportedFindType("find type not supported: " + type);

    }

    @Override
    public void deleteItemListById(String listId) {
        repository
                .findById(listId)
                .orElseThrow(()-> new IteListNotFoundException("Could Not found item list with id: + id"));

        repository.deleteById(listId);
    }

    @Override
    public List<ItemList> findAllItemListWhereUserParticipate(String userId) {
        return repository
                .findListOfaGivenUser(userId)
                .stream()
                .map(mapper::toDomainModel)
                .toList();
    }

    @Override
    public ItemList updateList(ItemList itemListToUpdate) {
        var updatedList = repository.save(mapper.fromDomainModel(itemListToUpdate));
        return mapper.toDomainModel(updatedList);
    }
}
