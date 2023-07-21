package com.homedecor.rest.entity;

import javax.persistence.*;

@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wishlist_id")
    private Long wishlist_id;

    public Long getWishlistId() {
        return wishlist_id;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlist_id = wishlistId;
    }

}
