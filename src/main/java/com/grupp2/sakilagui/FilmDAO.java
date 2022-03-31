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
}
