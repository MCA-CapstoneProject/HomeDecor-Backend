package com.homedecor.rest.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Cacheable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.homedecor.rest.dto.SellerDto;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "product_master")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ProductMaster")
public class ProductMaster implements java.io.Serializable {

    private Long productId;
    private Brand brand;
    private Category category;
    private String productName;
    private String description;
    private Integer ratings;
    private Integer quantity;
    private Boolean status;
    private String productCode;
    private Double retailPrice;
    private Set<ProductImages> productImageses = new HashSet<ProductImages>(0);
    private Seller seller;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")

    public Seller getSeller() {
        return this.seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "product_name", length = 155)

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "description", length = 1500)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "ratings")
    public Integer getRatings() {
        return this.ratings;
    }

    public void setRatings(Integer rating) {
        this.ratings = rating;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "product_code", length = 55)
    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productMaster")
    public Set<ProductImages> getProductImageses() {
        return this.productImageses;
    }
    public void setProductImageses(Set<ProductImages> productImageses) {
        this.productImageses = productImageses;
    }
    @Column(name = "retail_price", precision = 22, scale = 0)
    public Double getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    private Set<Cart> cartItems = new HashSet<Cart>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productMaster")

    public Set<Cart> getCartItems() {
        return this.cartItems;
    }
    public void setCartItems(Set<Cart> items) {
        this.cartItems = items;
    }

    private Set<Wishlist> wishlistItems = new HashSet<Wishlist>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productMaster")
    public Set<Wishlist> getWishlistItems() {
        return this.wishlistItems;
    }
    public void setWishlistItems(Set<Wishlist> items) {
        this.wishlistItems = items;
    }

    private Set<Order_Item> order_Item = new HashSet<Order_Item>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productMaster")

    public Set<Order_Item> getOrder_Item() {
        return this.order_Item;
    }
    public void setOrder_Item(Set<Order_Item> items) {
        this.order_Item = items;
    }


}
