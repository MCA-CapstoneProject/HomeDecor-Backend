package com.homedecor.rest.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="orders")
public class Order  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="order_id")
    private Long order_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="order_date", length = 19)
    private Date order_date;

    @Column(name="total_price")
    private Long total_price;

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
    private Payment payment;
    @JoinColumn(name = "payment_id")
    public Payment getPayment() {
        return this.payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Shipment shipment;
    @JoinColumn(name = "shipment_id")
    public Shipment getShipment() {
        return this.shipment;
    }
    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Order_Item> order_items = new HashSet<Order_Item>(0);
    public Set<Order_Item> getOrderItems() {
        return this.order_items;
    }
    public void setOrderItems(Set<Order_Item> order_items) {
        this.order_items = order_items;
    }

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