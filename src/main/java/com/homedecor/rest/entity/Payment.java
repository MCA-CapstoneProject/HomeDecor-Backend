package com.homedecor.rest.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "payment")
public class Payment  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="payment_id")
    private Long payment_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="payment_date",length=19)
    private Date payment_date;

    @Column(name="payment_method")
    private String payment_method;

    @Column(name="amount")
    private Long amount;

    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    private Set<Order> orders = new HashSet<Order>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
    public Set<Order> getOrders() {
        return this.orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Long getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(Long paymentId) {
        this.payment_id = paymentId;
    }

    public Date getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(Date paymentDate) {
        this.payment_date = paymentDate;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.payment_method = paymentMethod;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}

