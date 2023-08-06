package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductImages;

import java.util.Collection;

public interface ProductImagesDao {
    Collection<ProductImages> findAllProductImages();

    boolean existsById(Long id);

     ProductImages findById(Long id);

    void deleteById(Long id);

    void save(ProductImages productImagesMaster);
}
