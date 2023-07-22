/*
package com.homedecor.rest.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long sellerId;

    @Size(max = 20, min = 1, message = "Full name must be equal or less than '{max}'")
    @Column(name = "full_name")
    private String fullName;

    @Size(max = 10, min = 1, message = "username must be equal or less than '{max}'")
    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Size(max = 14, min = 1, message = "Phone must be equal or less than '{max}'")
    @Column(name = "phone")
    private String phone;

    @Column(name = "brand_name")
    private String brandName;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) { this.brandName = brandName; }



}
*/
