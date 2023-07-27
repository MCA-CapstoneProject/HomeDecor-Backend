package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerDaoImpl implements SellerDao {

    @Autowired
    SellerRepo sellerRepo;

    @Override
    public Seller findBySellerId(Long sellerId) {
        return sellerRepo.findBySellerId(sellerId);
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellerRepo.findAll();
    }

    @Override
    public boolean existsById(Long sellerId) {
        return sellerRepo.existsById(sellerId);
    }

    @Override
    public void save(Seller seller) {
        sellerRepo.save(seller);

    }

    @Override
    public void deleteById(Long sellerId) {
        sellerRepo.deleteById(sellerId);
    }

    @Override
    public boolean existsByUsername(String username) {
        return sellerRepo.existsByUserName(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return sellerRepo.existsByEmail(email);
    }

    @Override
    public Seller findByUserNameOrEmail(String userName, String email) {
        return sellerRepo.findByUserNameOrEmail(userName,email);
    }
}
