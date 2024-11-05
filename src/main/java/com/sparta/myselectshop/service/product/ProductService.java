package com.sparta.myselectshop.service.product;

import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.domain.User;
import com.sparta.myselectshop.domain.UserRoleEnum;
import com.sparta.myselectshop.dto.request.ProductMyPriceParam;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ItemForm;
import com.sparta.myselectshop.dto.response.ProductForm;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public static final int MIN_MY_PRICE = 100;

    public ProductForm createProduct(ProductParam param, User user) {
        Product product = productRepository.save(new Product(param, user));
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

    @Transactional(readOnly = true)
    public Page<ProductForm> getProducts(User user, int page, int size, String sortBy, boolean isAsc) {

        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        UserRoleEnum role = user.getRole();

        Page<Product> products;

        if (role == UserRoleEnum.USER) {
            products = productRepository.findALlByUser(user, pageable);
        } else {
            products = productRepository.findAll(pageable);
        }

        return products.map(ProductForm::new);
    }

    @Transactional
    public void updateBySearch(Long itemId, ItemForm form) {
        Product product = productRepository.findById(itemId)
                .orElseThrow(() -> new NullPointerException("해당 상품은 존재하지 않습니다."));

        product.updateByItemForm(form);
    }
}


