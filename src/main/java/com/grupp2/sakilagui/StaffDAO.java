package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="staff")
public class StaffDAO {
    @Id
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
}
