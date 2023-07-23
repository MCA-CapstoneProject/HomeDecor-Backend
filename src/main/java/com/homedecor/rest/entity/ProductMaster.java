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


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "product_master")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ProductMaster")
public class ProductMaster implements java.io.Serializable {

    private Long productId;
    private Brand brand;
    private User userByModifiedBy;
    private User userByCreatedBy;
    private Category category;
    private String productName;
    private String description;
    private Integer points;
    private Integer minimum;
    private Integer sortOrder;
    private Boolean status;
    private Integer viewedCounter;
    private Date createdOn;
    private Date modifiedOn;
    private String productCode;
    private Double retailPrice;
    private String tags;
    private Set<ProductImages> productImageses = new HashSet<ProductImages>(0);

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
    @JoinColumn(name = "modified_by")
    public User getUserByModifiedBy() {
        return this.userByModifiedBy;
    }

    public void setUserByModifiedBy(User userByModifiedBy) {
        this.userByModifiedBy = userByModifiedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    public User getUserByCreatedBy() {
        return this.userByCreatedBy;
    }

    public void setUserByCreatedBy(User userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
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

    @Column(name = "points")
    public Integer getPoints() {
        return this.points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Column(name = "minimum")
    public Integer getMinimum() {
        return this.minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "viewed_counter")
    public Integer getViewedCounter() {
        return this.viewedCounter;
    }

    public void setViewedCounter(Integer viewedCounter) {
        this.viewedCounter = viewedCounter;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", length = 19)
    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on", length = 19)
    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
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
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private Set<Cart> cart_items1 = new HashSet<Cart>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Cart> getCartItems() {
        return this.cart_items1;
    }
    public void setCartItems(Set<Cart> items) {
        this.cart_items1 = items;
    }

    private Set<Wishlist> wishlist_items = new HashSet<Wishlist>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Wishlist> getWishlistItems() {
        return this.wishlist_items;
    }
    public void setWishlistItems(Set<Wishlist> items) {
        this.wishlist_items = items;
    }

    private Set<Order_Item> order_items = new HashSet<Order_Item>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Order_Item> getOrderedItems() {
        return this.order_items;
    }
    public void setOrderedItems(Set<Order_Item> items) {
        this.order_items = items;
    }

    private Set<Seller> seller = new HashSet<Seller>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Seller> getSeller() {
        return this.seller;
    }
    public void setSeller(Set<Seller> items) {
        this.seller = items;
    }

}
