package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.domain.Folder;
import com.sparta.myselectshop.domain.Product;
import com.sparta.myselectshop.domain.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
    
}
