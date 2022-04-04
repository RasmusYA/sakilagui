package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;       //tinyint(3) unsigned	NO	PRI		auto_increment
    @Column(name = "first_name")
    private String firstName;	//varchar(45)	NO
    @Column(name = "last_name")
    private String lastName;	//varchar(45)	NO

//    @Column(name = "address_id")
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Address addressId;	    //smallint(5) unsigned	NO	MUL

    @Column(name = "picture")
    private byte[] picture;     //blob	YES
    @Column(name = "email")
    private String email;	    //varchar(50)	YES


    //@Column(name = "store_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store storeId;	    //tinyint(3) unsigned	NO	MUL

    @Column(name = "active")
    private Boolean active;	    //tinyint(1)	NO		1
    @Column(name = "username")
    private String username;	//varchar(16)	NO
    @Column(name = "password")
    private String password;	//varchar(40)	YES
    @Column(name = "last_update")
    private Date lastUpdate;	//timestamp	NO		current_timestamp()	on update current_timestamp()

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Rental> rentals = new ArrayList<>();

    public Staff(){

    }

    public Collection<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Collection<Rental> rentals) {
        this.rentals = rentals;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Address getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Address addressId) {
//        this.addressId = addressId;
//    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
