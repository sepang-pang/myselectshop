package com.sparta.myselectshop.controller.product;

import com.sparta.myselectshop.dto.request.ProductMyPriceParam;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.security.userdetails.UserDetailsImpl;
import com.sparta.myselectshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductForm createProduct(@RequestBody ProductParam param,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(param, userDetails.getUser());
    }

    @PutMapping("/products/{productId}")
    public ProductForm updateProduct(@PathVariable Long productId,
                                     @RequestBody ProductMyPriceParam param) {
        return productService.updateProduct(productId, param);
    }

    @GetMapping("/products")
    public Page<ProductForm> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.getProducts(userDetails.getUser(), page-1, size, sortBy, isAsc);
    }

    @PostMapping("/products/{productId}/folder")
    public void addFolder(
            @PathVariable Long productId,
            @RequestParam Long folderId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
      productService.addFolder(productId, folderId, userDetails.getUser());
    }
}
