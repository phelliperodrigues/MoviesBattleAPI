package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ibmd_id", unique = true)
    private String imdbId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "poster")
    private String poster;

    @Column(name = "score_total")
    private Double scoreTotal;
}