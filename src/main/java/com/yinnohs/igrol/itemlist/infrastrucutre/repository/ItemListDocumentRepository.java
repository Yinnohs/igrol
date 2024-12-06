package com.yinnohs.igrol.itemlist.infrastrucutre.repository;

import com.yinnohs.igrol.itemlist.infrastrucutre.document.ItemListDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemListDocumentRepository extends MongoRepository<ItemListDocument, String> {
    @Query("{ 'listOwner.id': ?0 }")
    List<ItemListDocument> findByListOwner(String userId);

    Optional<ItemListDocument> findByTitle(String title);

    @Query("{ 'participants.id': ?0 }")
    List<ItemListDocument> findListOfaGivenUser(String userId);
}
