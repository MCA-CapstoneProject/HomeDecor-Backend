package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepo extends JpaRepository<Seller, Long> {
    public Seller findBySellerId(Long sellerId);
    Optional<Seller> findByEmail(String email);
    Optional<Seller> findByUserName(String username);
    public boolean existsByUserName(String username);
    public boolean existsByEmail(String email);
    Seller findByUserNameOrEmail(String userName, String email);
}
