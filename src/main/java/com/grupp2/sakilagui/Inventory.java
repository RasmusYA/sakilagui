package com.grupp2.sakilagui;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int inventoryId;	    //mediumint(8) unsigned

    @Column(name = "payment_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Film filmId;	        //smallint(5) unsigned

    @Column(name = "payment_id")
    private int storeId;	        //tinyint(3) unsigned
    @Column(name = "payment_id")
    private int lastUpdate;	    //timestamp

    public Inventory(){

    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
