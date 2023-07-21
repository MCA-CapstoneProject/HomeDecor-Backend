package com.homedecor.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long order_id;

    @Column(name="order_date")
    private Date order_date;

    @Column(name="total_price")
    private Long total_price;


    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long orderId) {
        this.order_id = orderId;
    }

    public Date getOrderDate() {
        return order_date;
    }

    public void setOrderDate(Date orderDate) {
        this.order_date = orderDate;
    }

    public Long getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(Long total_price) {
        this.total_price = total_price;
    }

}