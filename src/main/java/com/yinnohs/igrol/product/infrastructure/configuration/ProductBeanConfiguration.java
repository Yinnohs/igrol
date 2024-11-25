package com.yinnohs.igrol.product.infrastructure.configuration;

import com.yinnohs.igrol.product.application.*;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfiguration {

    @Bean
    ChangeProductPriceUseCase changeProductPriceUseCase(ProductService productService){
        return  new ChangeProductPriceUseCase(productService);
    }
    @Bean
    ChangeProductImageUseCase changeProductImageUseCase(ProductService productService){
        return  new ChangeProductImageUseCase(productService);
    }
    @Bean
    ChangeProductNameUseCase changeProductNameUseCase(ProductService productService){
        return  new ChangeProductNameUseCase(productService);
    }
    @Bean
    CreateNewProductUseCase createNewProductUseCase(ProductService productService){
        return  new CreateNewProductUseCase(productService);
    }
    @Bean
    FindAllProductsUseCase findAllProductsUseCase(ProductService productService){
        return  new FindAllProductsUseCase(productService);
    }
    @Bean
    FindSpecificProductUseCase findSpecificProductUseCase(ProductService productService){
        return  new FindSpecificProductUseCase(productService);
    }
    @Bean
    DeleteProductUseCase deleteProductUseCase(ProductService productService){
        return  new DeleteProductUseCase(productService);
    }
}
