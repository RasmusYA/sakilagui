package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;                 //smallint(5) unsigned  NO PRI  auto_increment

    @Column(name = "city")
    private String city;                //varchar(50)   NO

    //@Column(name = "country_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country countryId;              //smallint(5)   NO

    @Column(name = "last_update")
    private Date lastUpdate;            //timestamp     NO

    public City(){

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}