package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;       //tinyint(3) unsigned	NO	PRI		auto_increment
    @Column(name = "first_name")
    private String firstName;	//varchar(45)	NO
    @Column(name = "last_name")
    private String lastName;	//varchar(45)	NO

    @Column(name = "address_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address addressId;	    //smallint(5) unsigned	NO	MUL

    @Column(name = "picture")
    private byte[] picture;     //blob	YES
    @Column(name = "email")
    private String email;	    //varchar(50)	YES

    @Column(name = "store_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Store storeId;	    //tinyint(3) unsigned	NO	MUL

    @Column(name = "active")
    private Boolean active;	    //tinyint(1)	NO		1
    @Column(name = "username")
    private String username;	//varchar(16)	NO
    @Column(name = "password")
    private String password;	//varchar(40)	YES
    @Column(name = "last_update")
    private Date lastUpdate;	//timestamp	NO		current_timestamp()	on update current_timestamp()


    public Staff(){

    }

}
