package com.homedecor.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipment_id")
    private Long shipment_id;

    @Column(name="shipment_date")
    private Date shipment_date;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="zip_code")
    private Integer zip_code;

    public Long getShipmentId() {
        return shipment_id;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipment_id = shipmentId;
    }

    public Date getShipmentDate() {
        return shipment_date;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipment_date = shipmentDate;
    }

    public String getAddress() {    return address;    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipcode() {
        return zip_code;
    }

    public void setZipcode(Integer zipCode) {
        this.zip_code = zipCode;
    }
}
