package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;	            //smallint(5) unsigned

// TODO Handle relation when Customer class is up
//    @Column(name = "customer_id")
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Customer customerId;	            //	smallint(5) unsigned

    //@Column(name = "staff_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff")
    private Staff staffId;	            //	tinyint(3) unsigned

    //@Column(name = "rental_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rental")
    private Rental rentalId;	            //	int(11)

    @Column(name = "amount")
    private double amount;	            //	decimal(5,2)
    @Column(name = "payment_date")
    private Date paymentDate;	        //	datetime
    @Column(name = "last_update")
    private Date lastUpdate;	        //	timestamp

    public Payment(){

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

// TODO Handle relation when Customer class is up
//    public Customer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Customer customerId) {
//        this.customerId = customerId;
//    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Rental getRentalId() {
        return rentalId;
    }

    public void setRentalId(Rental rentalId) {
        this.rentalId = rentalId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
