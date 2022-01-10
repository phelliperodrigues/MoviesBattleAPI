package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}