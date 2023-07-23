package com.homedecor.rest.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cart")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cart")
public class Cart  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="cart_id")
    private Long cart_id;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductMaster product;
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
