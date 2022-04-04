package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "film_actor")
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;           //	smallint(5) unsigned	NO	PRI

// TODO Handle relation when Film is up
//    @Column(name = "film_id")
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Film filmId;                //	smallint(5) unsigned	NO	PRI

    @Column(name = "last_update")
    private Date lastUpdate;       //	timestamp	NO		current_timestamp()	on update current_timestamp()


    public FilmActor(){

    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

// TODO Handle relation when Film is Up
//    public Film getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Film filmId) {
//        this.filmId = filmId;
//    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
