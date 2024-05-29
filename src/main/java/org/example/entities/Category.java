package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "movie", name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id",unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    private String categoryName;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Film>films = new HashSet<Film>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
