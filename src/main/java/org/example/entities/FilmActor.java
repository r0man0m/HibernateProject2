package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(schema = "movie", name = "film_actor")
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "actor_id",unique = true, nullable = false)
    private Integer actorId;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "film_id",unique = true, nullable = false)
    private Integer filmId;

    @UpdateTimestamp
    @Column(name = "last_updatate", nullable = false)
    private Instant lastUpdate;
}
