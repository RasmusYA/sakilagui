package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalId;      //	int(11)	NO	PRI		auto_increment

    @Column(name = "rental_date")
    //@Temporal(TemporalType.DATE)
    private Date rentalDate;      //	datetime	NO	MUL


//    //@Column(name = "inventory_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;      //	mediumint(8) unsigned	NO	MUL

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerId;      //	smallint(5) unsigned	NO	MUL

    @Column(name = "return_date")
    //@Temporal(TemporalType.DATE)
    private Date returnDate;      //	datetime	YES

    //@Column(name = "staffId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id")
    private Staff staffId;      //	tinyint(3) unsigned	NO	MUL


    @Column(name = "last_update")
    //@Temporal(TemporalType.DATE)
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

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return rentalId + " " +
                 rentalDate + " " +
                inventoryId + " " +
                customerId + " " +
                returnDate + " " +
                staffId + " " +
                lastUpdate + "\n";
    }
}
