package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;            //	smallint(5) unsigned	NO	PRI

    @Column(name = "category_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category categoryId;            //	tinyint(3) unsigned	NO	PRI

    @Column(name = "last_update")
    private Date lastUpdate;            //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public Category(){

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
