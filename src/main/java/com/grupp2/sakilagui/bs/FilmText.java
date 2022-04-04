package com.grupp2.sakilagui.bs;

import javax.persistence.*;

@Entity
@Table(name = "film_text")
public class FilmText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;                //	smallint(6)	NO	PRI
    @Column(name = "title")
    private String title;                //	varchar(255)	NO	MUL
    @Column(name = "description")
    private String description;                //	text	YES

    public FilmText(){

    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
