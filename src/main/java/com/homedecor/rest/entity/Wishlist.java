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
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    private ProductMaster productMaster;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public ProductMaster getProductMaster() {
        return this.productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    public Long getWishlistId() {
        return wishlist_id;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlist_id = wishlistId;
    }

}

