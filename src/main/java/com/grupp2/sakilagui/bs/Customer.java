package com.grupp2.sakilagui.bs;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;                 //smallint(5) unsigned  NO PRI  auto_increment

    //@Column(name = "store_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store storeId;                    //smallint(5)   NO

    @Column(name = "first_name")
    private String firstName;               //varchar(45)   NO

    @Column(name= "last_name")
    private String lastName;                //varchar(45)   NO

    @Column(name = "email")
    private String email;                   //varchar(50)   YES

    //@Column(name = "address_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address addressId;                  //smallint(5)   NO

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "active", columnDefinition = "TINYINT(1)", length = 1)
    private Boolean active;                 //tinyint(3)    NO

    @Column(name = "create_date")
    private Date createDate;                //datetime      NO

    @Column(name = "last_update")
    private Date lastUpdate;                //timestamp     YES

    public Customer(){

    }

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private Collection<Rental> rentals = new ArrayList<>();

    public Collection<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Collection<Rental> rentals) {
        this.rentals = rentals;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return firstName + lastName;
    }
}
