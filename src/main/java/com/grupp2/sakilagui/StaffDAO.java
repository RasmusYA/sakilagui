package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="staff")
public class StaffDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int staff_id; // TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name="first_name")
    String firstName; //VARCHAR(45) NOT NULL,

    @Column(name="last_name")
    String lastName; //  VARCHAR(45) NOT NULL,

    @Column(name="address_id")
    int address_id; // SMALLINT UNSIGNED NOT NULL,

    @Column(name="picture")
    Blob picture; // BLOB DEFAULT NULL,

    @Column(name="email")
    String email; // VARCHAR(50) DEFAULT NULL,

    @Column(name="store_id")
    int store_id; // TINYINT UNSIGNED NOT NULL,

    @Column(name="active")
    boolean active; // BOOLEAN NOT NULL DEFAULT TRUE,

    @Column(name="username")
    String username; // VARCHAR(16) NOT NULL,

    @Column(name="password")
    String password; // VARCHAR(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,

    @Column(name="last_update")
    Date last_update; // TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
