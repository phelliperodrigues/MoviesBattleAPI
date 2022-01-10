package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}