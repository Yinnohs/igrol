package com.yinnohs.igrol.product.infrastructure.service;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.port.ProductRepository;
import com.yinnohs.igrol.product.domain.service.ProductService;
import com.yinnohs.igrol.shared.exception.NotSupportedFindType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final String TYPE_FIND_BY_ID = "id";
    private final String TYPE_FIND_BY_NAME = "name";
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public Product findBy(String type,  String value){
        if (TYPE_FIND_BY_ID.equals(type)) return productRepository.findById(value);
        if (TYPE_FIND_BY_NAME.equals(type))return productRepository.findByName(value);
        throw new NotSupportedFindType("Find type not supported please try to find by id, name or price");
    }

    @Override
    public Product create(Product product){
        return productRepository.save(product);
    }

    @Override
    public void deleteById(String productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
