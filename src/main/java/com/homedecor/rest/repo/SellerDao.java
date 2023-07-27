package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Seller;

import java.util.List;

public interface SellerDao {
    Seller findBySellerId(Long sellerId);
    List<Seller> findAllSellers();

    boolean existsById(Long sellerId);

    void save(Seller seller);

    void deleteById(Long sellerId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Seller findByUserNameOrEmail(String userName, String email);

}
