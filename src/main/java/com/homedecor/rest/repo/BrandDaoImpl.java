package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl implements BrandDao {
    @Autowired
    BrandRepo BrandRepo;


    @Override
    public List<Brand> findAllBrands() {
        return BrandRepo.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return BrandRepo.findByBrandId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return BrandRepo.existsById(id);
    }

    @Override
    public void save(Brand Brand) {
         BrandRepo.save(Brand);
    }

    @Override
    public void deleteById(Long id) {
        BrandRepo.deleteById(id);
    }
}

