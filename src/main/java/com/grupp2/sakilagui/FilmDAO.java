package com.grupp2.sakilagui;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="film")
public class FilmDAO {
    enum Rating {
        G,
        PG,
        PG13,
        R,
        NC17
    }


    @Id
    int film_id; // SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name= "title")
    String title; // VARCHAR(128) NOT NULL,

    @Column
    String description; // TEXT DEFAULT NULL,

    @Column(name="release_year")
    String releaseYear; // YEAR  DEFAULT NULL,

    @Column(name="language_id")
    int languageID; // TINYINT UNSIGNED NOT NULL,

    @Column(name="original_language_id")
    String originalLanguageID; // TINYINT UNSIGNED DEFAULT NULL,

    @Column(name="rental_duration")
    int rental_duration; // TINYINT UNSIGNED NOT NULL DEFAULT 3,

    @Column(name="rental_rate")
    float rentalRate; // DECIMAL(4,2) NOT NULL DEFAULT 4.99,

    @Column
    int length; // SMALLINT UNSIGNED DEFAULT NULL,

    @Column(name="replacement_cost")
    float replacementCost; // DECIMAL(5,2) NOT NULL DEFAULT 19.99,

    @Column
    Rating rating; // ENUM('G','PG','PG-13','R','NC-17') DEFAULT 'G',

    // TODO: Handle the SET datatype:
    /*
    @Column(name="special_features")
    specialFeatures; // SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,*/

    @Column(name="last_update")
    Date lastUpdate; // TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getOriginalLanguageID() {
        return originalLanguageID;
    }

    public void setOriginalLanguageID(String originalLanguageID) {
        this.originalLanguageID = originalLanguageID;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
