package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="city")
public class CityDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int cityID; // SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name="city")
    String city; // VARCHAR(50) NOT NULL,

    @Column(name="country_id")
    int countryID; // SMALLINT UNSIGNED NOT NULL,

    @Column(name="last_update")
    Date lastUpdate; // TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
