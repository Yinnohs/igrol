package com.yinnohs.igrol.product.infrastructure.repository;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.infrastructure.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDocumentRepository extends MongoRepository<ProductDocument, String> {
    List<Product> findByPrice(BigDecimal price);
    Optional<Product> findByName(String name);
}
