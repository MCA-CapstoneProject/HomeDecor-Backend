package com.homedecor.rest.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cart")
public class Cart  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="cart_id")
    private Long cart_id;

    @Column(name="quantity")
    private Integer quantity;


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

    public Long getCartId() {
        return cart_id;
    }

    public void setCartId(Long cartId) {
        this.cart_id = cartId;
    }

    public Integer getCartQuantity() {
        return quantity;
    }

    public void setCartQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
