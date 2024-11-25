package com.yinnohs.igrol.product.infrastructure.controller;

import com.yinnohs.igrol.product.application.*;
import com.yinnohs.igrol.product.infrastructure.dto.CreateProductRequest;
import com.yinnohs.igrol.product.infrastructure.dto.UpdateProductImageRequest;
import com.yinnohs.igrol.product.infrastructure.dto.UpdateProductNameRequest;
import com.yinnohs.igrol.product.infrastructure.dto.UpdateProductPriceRequest;
import com.yinnohs.igrol.product.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final FindSpecificProductUseCase findSpecificProductUseCase;
    private final CreateNewProductUseCase createNewProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ChangeProductImageUseCase changeProductImageUseCase;
    private final ChangeProductNameUseCase changeProductNameUseCase;
    private final ChangeProductPriceUseCase changeProductPriceUseCase;



    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(
                createNewProductUseCase
                        .apply(productMapper.createRequestToDocument(request))
        );
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        return ResponseEntity.ok(findAllProductsUseCase.apply(null));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findBy(
        @RequestParam(name = "type") String findType,
        @RequestParam(name = "value") String value
    ){
        return ResponseEntity.ok(findSpecificProductUseCase
                .apply(findType,value));
    }

    @DeleteMapping("/productId")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){
         deleteProductUseCase.apply(productId);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/name")
    public ResponseEntity<?> updateProductName(@RequestBody UpdateProductNameRequest request){
        return ResponseEntity.ok(changeProductNameUseCase.apply(request.productId(), request.name()));
    }

    @PutMapping("/price")
    public ResponseEntity<?> updateProductPrice(@RequestBody UpdateProductPriceRequest request){
        return ResponseEntity.ok(changeProductPriceUseCase.apply(request.productId(), request.price()));
    }

    @PutMapping("/image")
    public ResponseEntity<?> updateProductImage(@RequestBody UpdateProductImageRequest request){
        return ResponseEntity.ok(changeProductImageUseCase.apply(request.productId(), request.imageUrl()));
    }


}
