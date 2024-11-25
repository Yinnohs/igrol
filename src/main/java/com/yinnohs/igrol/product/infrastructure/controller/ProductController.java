package com.yinnohs.igrol.product.infrastructure.controller;

import com.yinnohs.igrol.product.application.service.ProductServiceImpl;
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
    private final ProductServiceImpl productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(
                productService
                        .create(
                                productMapper.createRequestToDocument(request)
                        )
        );
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<?> findBy(
        @RequestParam(name = "type") String findType,
        @RequestParam(name = "value") String value
    ){
        return ResponseEntity.ok(productService.findBy(findType,value));
    }

    @DeleteMapping("/productId")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){
         productService.deleteById(productId);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/name")
    public ResponseEntity<?> updateProductName(@RequestBody UpdateProductNameRequest request){
        return ResponseEntity.ok(productService.updateProductName(request.productId(), request.name()));
    }

    @PutMapping("/price")
    public ResponseEntity<?> updateProductPrice(@RequestBody UpdateProductPriceRequest request){
        return ResponseEntity.ok(productService.updateProductPrice(request.productId(), request.price()));
    }

    @PutMapping("/image")
    public ResponseEntity<?> updateProductImage(@RequestBody UpdateProductImageRequest request){
        return ResponseEntity.ok(productService.updateProductImage(request.productId(), request.imageUrl()));
    }


}
