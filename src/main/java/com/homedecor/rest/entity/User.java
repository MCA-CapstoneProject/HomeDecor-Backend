package com.homedecor.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",
        indexes = {@Index(columnList = "phone", unique = true, name = "number")}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Size(max = 20, min = 1, message = "Full name must be equal or less than '{max}'")
    @Column(name = "full_name")
    private String fullName;

    @Size(max = 6, min = 1, message = "Gender must be equal or less than '{max}'")
    @Column(name = "gender")
    private String gender;

    @Size(max = 14, min = 1, message = "Phone must be equal or less than '{max}'")
    @Column(name = "phone")
    private String phone;

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

}
