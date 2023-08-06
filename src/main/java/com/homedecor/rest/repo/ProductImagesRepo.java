package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepo extends JpaRepository<ProductImages, Long> {
    public boolean existsById(Long id);
    void deleteById(Long id);
    ProductImages findByProductImagesId(Long id);
}
