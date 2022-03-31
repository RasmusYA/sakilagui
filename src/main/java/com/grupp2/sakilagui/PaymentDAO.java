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
}
