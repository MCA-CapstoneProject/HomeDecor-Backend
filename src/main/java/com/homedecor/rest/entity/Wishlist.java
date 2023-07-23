package com.homedecor.rest.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "wishlist")
public class Wishlist  implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="wishlist_id")
    private Long wishlist_id;

    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    private ProductMaster product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public ProductMaster getProduct() {
        return this.product;
    }
    public void setProduct(ProductMaster product) {
        this.product = product;
    }

    public Long getWishlistId() {
        return wishlist_id;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlist_id = wishlistId;
    }

}

