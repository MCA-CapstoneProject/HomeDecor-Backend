package com.homedecor.rest.repo;


import com.homedecor.rest.entity.ProductMaster;

import java.util.List;

public interface ProductMasterDao {
    List<ProductMaster> findAllProducts();

    ProductMaster findById(Long id);

    boolean existsById(Long id);

    void save(ProductMaster ProductMaster);

    void deleteById(Long id);
}

