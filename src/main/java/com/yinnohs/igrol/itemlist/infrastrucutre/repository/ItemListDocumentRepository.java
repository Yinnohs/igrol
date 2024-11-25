package com.yinnohs.igrol.itemlist.infrastrucutre.repository;

import com.yinnohs.igrol.itemlist.infrastrucutre.document.ItemListDocument;
import com.yinnohs.igrol.user.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemListDocumentRepository extends MongoRepository<ItemListDocument, String> {
    List<ItemListDocument> findByListOwner(User owner);
    Optional<ItemListDocument> findByTitle(String title);
}
