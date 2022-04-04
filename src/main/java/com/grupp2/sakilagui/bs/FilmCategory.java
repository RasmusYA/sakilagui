package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "film_category")
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;

    //@Column(name = "category_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category categoryId;        //	tinyint(3) unsigned	NO	PRI

    @Column(name = "last_update")
    private Date lastUpdate;        //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public FilmCategory(){

    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
