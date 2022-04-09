package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "film_actor")
public class FilmActor implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", foreignKey = @ForeignKey(name = "fk_film_actor_actor"))
    private Actor actor;           //	smallint(5) unsigned	NO	PRI

// TODO Handle relation when Film is up
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;                //	smallint(5) unsigned	NO	PRI

    @Column(name = "last_update")
    private Date lastUpdate;       //	timestamp	NO		current_timestamp()	on update current_timestamp()


    public FilmActor(){

    }

    public Actor getActorId() {
        return actor;
    }

    public void setActorId(Actor actorId) {
        this.actor = actorId;
    }

// TODO Handle relation when Film is Up
    public Film getFilmId() {
        return film;
    }

    public void setFilmId(Film filmId) {
        this.film = filmId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
