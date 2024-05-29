package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(schema = "movie", name = "film_category")
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", unique = true, nullable = false)
    private Integer filmId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", unique = true, nullable = false)
    private Integer categoryId;


    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}


