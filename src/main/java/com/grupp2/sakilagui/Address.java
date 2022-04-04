package com.grupp2.sakilagui;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;              // smallint(5) unsigned     NO PRI      auto_increment

    @Column(name = "address")
    private String address;             //varchar(50)   NO

    @Column(name = "address2")
    private String address2;            //varchar(50)   YES

    @Column(name = "district")
    private String district;            //varchar(20)   NO

    @Column(name = "city_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int cityId;                 //smallint(5)   NO

    @Column(name = "postal_code")
    private String postalCode;          //varchar(10)   YES

    @Column(name = "phone")
    private String phone;               //varchar(20)   NO

    @Column(name = "location")
    private String location;            //geometry(??)  NO

    @Column(name = "last_update")
    private Date lastUpdate;            //timestamp     NO

    public Address() {

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}