package com.yinnohs.igrol.product.infrastructure.repository;

import com.yinnohs.igrol.product.domain.exception.ProductNotFoundException;
import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.port.ProductRepository;
import com.yinnohs.igrol.product.infrastructure.document.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductMongoRepository implements ProductRepository {

    private final ProductDocumentRepository productDocumentRepository;
    @Override
    public List<Product> findAll() {
        return productDocumentRepository
                .findAll()
                .stream()
                .map(ProductDocument::toProductModel)
                .toList();
    }

    @Override
    public Product findById(String productId) {
        ProductDocument product = productDocumentRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Could not be found product with id: " + productId));
        return ProductDocument.toProductModel(product);
    }

    @Override
    public Product save(Product product) {
        ProductDocument productToSave = ProductDocument.fromProductModel(product);
        ProductDocument savedProduct = productDocumentRepository.save(productToSave);
        return ProductDocument.toProductModel(savedProduct);
    }

    @Override
    public Boolean deleteById(String productId) {
        productDocumentRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Could not be found product with id: " + productId));

        productDocumentRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product findByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public Product findByName(String productName) {
        ProductDocument product = productDocumentRepository.findByName(productName)
                .orElseThrow(()-> new ProductNotFoundException("Could not be found product with name: " + productName));
        return ProductDocument.toProductModel(product);
    }
}
