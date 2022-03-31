package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name=”actor”)
public class ActorDAO {

    @Id
    long actor_id;

    @Column(name="first_name")
    String FirstName; // VARCHAR(45) NOT NULL,

    @Column(name="last_name")
    String LastName; // VARCHAR(45) NOT NULL,

    @Column(name="last_update")
    Date LastUpdate // TIMESTAMP; // NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
}
