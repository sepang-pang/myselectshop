package com.sparta.myselectshop.service.product;

import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductForm createProduct(ProductParam param) {
        Product product = productRepository.save(new Product(param));
        return new ProductForm(product);
    }
}
