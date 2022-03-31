package com.grupp2.sakilagui;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalId;      //	int(11)	NO	PRI		auto_increment

    @Column(name = "rental_date")
    private Date rentalDate;      //	datetime	NO	MUL

    @Column(name = "inventory_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Inventory inventoryId;      //	mediumint(8) unsigned	NO	MUL

    // TODO Handle relation when Customer is upp
//    @Column(name = "customer_id")
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Customer customerId;      //	smallint(5) unsigned	NO	MUL

    @Column(name = "return_date")
    private Date returnDate;      //	datetime	YES

    @Column(name = "staffId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Staff staff_id;      //	tinyint(3) unsigned	NO	MUL

    @Column(name = "last_update")
    private Date lastUpdate;      //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public Rental(){

    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    // TODO Handle relation when Store
//    public Customer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Customer customerId) {
//        this.customerId = customerId;
//    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Staff staff_id) {
        this.staff_id = staff_id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
