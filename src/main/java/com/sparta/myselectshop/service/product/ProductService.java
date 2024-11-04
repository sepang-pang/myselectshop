package com.sparta.myselectshop.service.product;

import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.dto.request.ProductMyPriceParam;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public static final int MIN_MY_PRICE = 100;

    public ProductForm createProduct(ProductParam param) {
        Product product = productRepository.save(new Product(param));
        return new ProductForm(product);
    }


    @Transactional
    public ProductForm updateProduct(Long productId, ProductMyPriceParam param) {
        int myPrice = param.getMyPrice();
        if (myPrice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않는 관심 가격입니다. 최소 " + MIN_MY_PRICE + "원 이상으로 설정해주세요.");
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NullPointerException("해당 상품을 찾을 수 없습니다."));

        product.update(param);

        return new ProductForm(product);
    }

    public List<ProductForm> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductForm::new)
                .collect(Collectors.toList());
    }
}
