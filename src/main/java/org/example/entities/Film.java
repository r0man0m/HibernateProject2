package org.example.entities;

import jakarta.persistence.*;
import org.example.enums.Rating;
import org.hibernate.annotations.ColumnDefault;

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
    @Column(name = "film_id")
    private Integer id;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "CLOB")
    private char[] description;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_year")
    private Year releaseDate;

    @Column(name = "rental_duration")
    private Integer rentalDuration = 3;

    @Column(name = "rental_rate")
    @ColumnDefault("4.2")
    private Double rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost")
    @ColumnDefault("5.2")
    private Double replacementCoast;

    @Enumerated(EnumType.ORDINAL)
    @ColumnDefault("G")
    private Rating rating;

    @ElementCollection
    private Set<String> specialFeatures;

    @Column(name = "last_update")
    private Instant lastUpdate;

    public Film() {
        specialFeatures = new HashSet<>(Arrays.asList("Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes"));
    }
    @PrePersist
    private void setRentalRate(){
        if(rentalRate < 4.2){
            rentalRate = 4.2;
        }
        if(rentalRate > 4.99){
            rentalRate = 4.99;
        }
        if (replacementCoast < 5.2){
            replacementCoast = 5.2;
        }
        if(replacementCoast > 19.99){
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
}
