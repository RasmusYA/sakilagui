package com.grupp2.sakilagui.bs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;                 //smallint(5) unsigned  NO PRI  auto_increment

    @Column(name = "title")
    private String title;               //varchar(128)  NO

    @Column(name = "description")
    private String description;         //text          YES

    @Column(name = "release_year")
    private int releaseYear;            //year          YES

    @Column(name = "language_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int languageId;             //tinyint(3)    NO

    @Column(name = "original_language_id")
    private int originalLanguageId;     //tinyint(3)    YES

    @Column(name = "rental_duration")
    private int rentalDuration;         //tinyint(3)    NO

    @Column(name = "rental_rate")
    private double rentalRate;          //decimal(4,2)  NO

    @Column(name = "length")
    private int length;                 //smallint(5)   YES

    @Column(name = "replacement_cost")
    private double replacementCost;     //decimal(5,2)  NO

    @Column(name = "rating")
    private String rating;              //              YES

    @Column(name = "special_features")
    private String specialFeatures;     //              YES

    @Column(name = "last_update")
    private Date lastUpdate;            //timestamp     NO

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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(int originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
