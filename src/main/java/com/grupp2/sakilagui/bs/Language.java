package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;            //	tinyint(3) unsigned	NO	PRI		auto_increment
    @Column(name = "name")
    private String name;            //	char(20)	NO
    @Column(name = "last_update")
    private Date lastUpdate;            //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public Language(){

    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return name + "";
    }
}
