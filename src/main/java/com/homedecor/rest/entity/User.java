package com.homedecor.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user",
        indexes = {@Index(columnList = "phone", unique = true, name = "number")},
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_name"}),
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long userId;

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

    @Size(max = 6, min = 1, message = "Gender must be equal or less than '{max}'")
    @Column(name = "gender")
    private String gender;

    @Size(max = 14, min = 1, message = "Phone must be equal or less than '{max}'")
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    private Set<Shipment> shipments = new HashSet<Shipment>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Shipment> getShipment() {
        return this.shipments;
    }
    public void setShipment(Set<Shipment> shipment) {
        this.shipments = shipment;
    }

    private Set<Order> orders = new HashSet<Order>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Order> getOrders() {
        return this.orders;
    }
    public void setOrders(Set<Order> order) {
        this.orders = order;
    }

    private Set<Cart> cart_items = new HashSet<Cart>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Cart> getCartItem() {
        return this.cart_items;
    }

    public void setCartItem(Set<Cart> cart) {
        this.cart_items = cart;
    }

    private Set<Wishlist> wishlisted = new HashSet<Wishlist>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Wishlist> getWishlisted() {
        return this.wishlisted;
    }
    public void setWishlisted(Set<Wishlist> wishlist) {
        this.wishlisted = wishlist;
    }

    private Set<Payment> payments = new HashSet<Payment>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Payment> getPayments() {
        return this.payments;
    }
    public void setPayments(Set<Payment> payment) {
        this.payments = payment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
