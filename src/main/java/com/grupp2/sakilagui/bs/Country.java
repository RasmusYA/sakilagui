package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;             //	smallint(5) unsigned	NO	PRI		auto_increment

    @Column(name = "country")
    private String country;             //	varchar(50)	NO

    @Column(name = "last_update")
    private Date lastUpdate;             //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public Country(){

    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
