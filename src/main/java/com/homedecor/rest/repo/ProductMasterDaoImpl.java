package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductMasterDaoImpl implements ProductMasterDao {
    @Autowired
    ProductMasterRepo ProductMasterRepo;


    @Override
    public List<ProductMaster> findAllProducts() {
        return ProductMasterRepo.findAll();
    }

    @Override
    public ProductMaster findById(Long id) {
        return ProductMasterRepo.findByProductMasterId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return ProductMasterRepo.existsById(id);
    }

    @Override
    public void save(ProductMaster ProductMaster) {
         ProductMasterRepo.save(ProductMaster);
    }

    @Override
    public void deleteById(Long id) {
        ProductMasterRepo.deleteById(id);
    }
}

