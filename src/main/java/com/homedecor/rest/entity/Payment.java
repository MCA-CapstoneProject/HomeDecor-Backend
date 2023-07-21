package com.homedecor.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long payment_id;

    @Column(name="payment_date")
    private Date payment_date;

    @Column(name="payment_method")
    private String payment_method;

    @Column(name="amount")
    private Long amount;


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
