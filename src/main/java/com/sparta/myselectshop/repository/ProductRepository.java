package com.sparta.myselectshop.repository;


import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findALlByUser(User user, Pageable pageable);

    Page<Product> findAllByUserAndProductFolders_FolderId(User user, Long folderId, Pageable pageable);
}
