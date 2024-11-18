package com.yinnohs.igrol.product.application.service;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.port.ProductRepository;
import com.yinnohs.igrol.shared.exception.NotSupportedFindType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final String TYPE_FIND_BY_ID = "id";
    private final String TYPE_FIND_BY_PRICE = "price";
    private final String TYPE_FIND_BY_NAME = "name";

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findBy(String type,  String value){
        String sanitizeType = type.toLowerCase().trim();
        if (TYPE_FIND_BY_ID.equals(sanitizeType)) return productRepository.findById(value);
        if (TYPE_FIND_BY_NAME.equals(sanitizeType))return productRepository.findByName(value);
        if (TYPE_FIND_BY_PRICE.equals(sanitizeType) && checkIfValidPrice(value)){
            BigDecimal transformedPrice = BigDecimal.valueOf(Double.parseDouble(value));
            return productRepository.findByPrice(transformedPrice);
        }
        throw new NotSupportedFindType("Find type not supported please try to find by id, name or price");
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public void deleteById(String productId){
        productRepository.deleteById(productId);
    }

    public Product updateProductPrice(String productId, BigDecimal newPrice){
        Product productToUpdate = productRepository.findById(productId);
        productToUpdate.setPrice(newPrice);
        return productRepository.save(productToUpdate);
    }

    public Product updateProductName(String productId, String name){
        Product productToUpdate = productRepository.findById(productId);
        productToUpdate.setName(name);
        return productRepository.save(productToUpdate);
    }

    public Product updateProductImage(String productId, String imageUrl){
        Product productToUpdate = productRepository.findById(productId);
        productToUpdate.setImageUrl(imageUrl);
        return productRepository.save(productToUpdate);
    }

    private boolean checkIfValidPrice(String price){
        try{
            Double.parseDouble(price);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}