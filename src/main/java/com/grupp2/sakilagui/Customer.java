package com.grupp2.sakilagui;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;                 //smallint(5) unsigned  NO PRI  auto_increment

    @Column(name = "store_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int storeId;                    //smallint(5)   NO

    @Column(name = "first_name")
    private String firstName;               //varchar(45)   NO

    @Column(name= "last_name")
    private String lastName;                //varchar(45)   NO

    @Column(name = "email")
    private String email;                   //varchar(50)   YES

    @Column(name = "address_id")
    private int addressId;                  //smallint(5)   NO

    @Column(name = "active")
    private Boolean active;                 //tinyint(3)    NO

    @Column(name = "create_date")
    private Date createDate;                //datetime      NO

    @Column(name = "last_update")
    private Date lastUpdate;                //timestamp     YES

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
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
}
