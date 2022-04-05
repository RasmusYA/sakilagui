package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;	    //mediumint(8) unsigned

    // TODO Handle relation when Film class is up
//    @Column(name = "payment_id")
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Film filmId;	        //smallint(5) unsigned

    //@Column(name = "store_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store storeId;	        //tinyint(3) unsigned

    @Column(name = "last_update")
    private int lastUpdate;	    //timestamp


    @OneToMany(mappedBy = "inventoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Rental> rentals = new ArrayList<>();

    public Collection<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Collection<Rental> rentals) {
        this.rentals = rentals;
    }

    public Inventory(){

    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    // TODO Handle relation when Film class is up
//    public Film getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Film filmId) {
//        this.filmId = filmId;
//    }


    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
