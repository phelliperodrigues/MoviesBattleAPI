package dev.phelliperodrigues.moviebattle.domain.interfaces.facade;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;

import java.util.Optional;

public interface MatchRepositoryFacade {
    Match save(Match match);

    void endsPreviousMatchByPlayerId(Long playerId);

    Optional<Match> findById(Long id);
}
