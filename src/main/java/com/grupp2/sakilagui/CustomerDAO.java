package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="customer")
public class CustomerDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int customer_id; // SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name="store_id")
    int storeID; // TINYINT UNSIGNED NOT NULL,

    @Column(name="first_name")
    String firstName; // VARCHAR(45) NOT NULL,

    @Column(name="last_name")
    String lastName; // VARCHAR(45) NOT NULL,

    @Column(name="email")
    String email; // VARCHAR(50) DEFAULT NULL,

    @Column(name="address_id")
    int addressID; // SMALLINT UNSIGNED NOT NULL,

    @Column(name="active")
    boolean active; // BOOLEAN NOT NULL DEFAULT TRUE,

    @Column(name="create_date")
    Date createDate; // DATETIME NOT NULL,

    @Column(name="last_update")
    Date last_update; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
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

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
