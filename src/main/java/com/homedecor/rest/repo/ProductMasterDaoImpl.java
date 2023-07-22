package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductMasterDaoImpl implements ProductMasterDao {
    @Autowired
    ProductMasterRepo productMasterRepo;


    @Override
    public List<ProductMaster> findAllProducts() {
        return productMasterRepo.findAll();
    }

    @Override
    public ProductMaster findById(Long id) {
        return productMasterRepo.findByProductId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productMasterRepo.existsById(id);
    }

    @Override
    public void save(ProductMaster ProductMaster) {
         productMasterRepo.save(ProductMaster);
    }

    @Override
    public void deleteById(Long id) {
        productMasterRepo.deleteById(id);
    }
}

