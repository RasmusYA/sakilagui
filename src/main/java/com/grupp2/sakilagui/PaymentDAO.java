package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="payment")
public class PaymentDAO {
    @Id
    int payment_id; // SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name="customer_id")
    int customerID; // SMALLINT UNSIGNED NOT NULL,

    @Column(name="staff_id")
    int staffID; // TINYINT UNSIGNED NOT NULL,

    @Column(name="rental_id")
    int rentalID; // INT DEFAULT NULL,

    @Column
    float amount; // DECIMAL(5,2) NOT NULL,

    @Column(name="payment_date")
    Date paymentDate; // DATETIME NOT NULL,

    @Column(name="last_update")
    Date lastUpdate; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
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
