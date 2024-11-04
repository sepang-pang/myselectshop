package com.sparta.myselectshop.controller.product;

import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductForm createProduct(@RequestBody ProductParam param) {
        return productService.createProduct(param);
    }
}
