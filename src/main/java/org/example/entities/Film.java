package org.example.entities;

import jakarta.persistence.*;
import org.example.enums.Rating;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.Year;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "movie", name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "CLOB")
    private char[] description;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_year")
    private Year releaseDate;

    @Column(name = "rental_duration", unique = true, nullable = false)
    private Integer rentalDuration = 3;

    @Column(name = "rental_rate", nullable = false)
    @ColumnDefault("4.2")
    private Double rentalRate;

    @Column(name = "length", unique = true)
    private Integer length;

    @Column(name = "replacement_cost", nullable = false)
    @ColumnDefault("5.2")
    private Double replacementCoast;

    @Enumerated(EnumType.ORDINAL)
    @ColumnDefault("G")
    private Rating rating;

    @ElementCollection
    private Set<String> specialFeatures;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Actor>actors = new HashSet<Actor>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Category>categories = new HashSet<Category>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Set<Language>languages = new HashSet<Language>();

    public Film() {
        specialFeatures = new HashSet<>(Arrays.asList("Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes"));
    }

    @PrePersist
    private void setRentalRate() {
        if (rentalRate < 4.2) {
            rentalRate = 4.2;
        }
        if (rentalRate > 4.99) {
            rentalRate = 4.99;
        }
        if (replacementCoast < 5.2) {
            replacementCoast = 5.2;
        }
        if (replacementCoast > 19.99) {
            replacementCoast = 19.99;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public char[] getDescription() {
        return description;
    }

    public void setDescription(char[] description) {
        this.description = description;
    }

    public Year getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Year releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCoast() {
        return replacementCoast;
    }

    public void setReplacementCoast(Double replacementCoast) {
        this.replacementCoast = replacementCoast;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Set<String> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Set<String> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
