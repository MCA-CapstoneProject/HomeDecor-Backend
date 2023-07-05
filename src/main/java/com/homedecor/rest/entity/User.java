package com.homedecor.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",
        indexes = {@Index(columnList = "phone", unique = true, name = "number")},
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Size(max = 20, min = 1, message = "Full name must be equal or less than '{max}'")
    @Column(name = "full_name")
    private String fullName;

    @Size(max = 10, min = 1, message = "username must be equal or less than '{max}'")
    @Column(name = "username")
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String gender) {
        this.username = username;
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
