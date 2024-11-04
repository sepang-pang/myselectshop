package com.sparta.myselectshop.controller.product;

import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.dto.request.ProductMyPriceParam;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductForm createProduct(@RequestBody ProductParam param) {
        return productService.createProduct(param);
    }

    @PutMapping("/products/{productId}")
    public ProductForm updateProduct(@PathVariable Long productId,
                                     @RequestBody ProductMyPriceParam param) {
        return productService.updateProduct(productId, param);
    }
}
