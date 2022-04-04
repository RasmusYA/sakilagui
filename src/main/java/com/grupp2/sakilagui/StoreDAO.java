package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="store")
public class StoreDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int storeID; // TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name="manager_staff_id")
    int managerStaffID; // TINYINT UNSIGNED NOT NULL,

    @Column(name="address_id")
    int addressID; // SMALLINT UNSIGNED NOT NULL,

    @Column(name="last_update")
    Date lastUpdate; // TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(int managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
