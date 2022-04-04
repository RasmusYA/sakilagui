package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name=”actor”)
public class ActorDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long actorID;

    @Column(name="first_name")
    String firstName; // VARCHAR(45) NOT NULL,

    @Column(name="last_name")
    String lastName; // VARCHAR(45) NOT NULL,

    @Column(name="last_update")
    Date lastUpdate; // TIMESTAMP; // NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public long getActorID() {
        return actorID;
    }

    public void setActorID(long actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
