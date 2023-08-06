package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductImagesDaoImpl implements ProductImagesDao {
    @Autowired
    ProductImagesRepo productImagesRepo;


    @Override
    public List<ProductImages> findAllProductImages() {
        return productImagesRepo.findAll();
    }

    @Override
    public ProductImages findById(Long id) {
        return productImagesRepo.findByProductImagesId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productImagesRepo.existsById(id);
    }

    @Override
    public void save(ProductImages productImages) {
        productImagesRepo.save(productImages);
    }

    @Override
    public void deleteById(Long id) {
        productImagesRepo.deleteById(id);
    }
}

