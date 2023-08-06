package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMasterRepo extends JpaRepository<ProductMaster, Long> {
    public boolean existsById(Long id);

    void deleteById(Long id);

    ProductMaster findByProductId(Long id);
}
