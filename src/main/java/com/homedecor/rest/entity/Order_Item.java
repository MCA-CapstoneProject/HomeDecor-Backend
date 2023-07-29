package com.homedecor.rest.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "order_item")
public class Order_Item  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="order_item_id")
    private Long order_item_id;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
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

    public Long getOrderItemId() {
        return order_item_id;
    }

    public void setOrderItemId(Long orderItemId) {
        this.order_item_id = orderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
