package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "movie", name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name" , length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Film>films = new HashSet<Film>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

