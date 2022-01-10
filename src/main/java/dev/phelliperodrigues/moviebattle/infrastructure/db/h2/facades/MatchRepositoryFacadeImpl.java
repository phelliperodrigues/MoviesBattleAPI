package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.facades;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.MatchRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchRepositoryFacadeImpl implements MatchRepositoryFacade {

    private final MatchRepository repository;
    @Override
    public Match save(Match match) {
        return repository.saveAndFlush(match);
    }

    @Override
    public void endsPreviousMatchByPlayerId(Long playerId) {

    }

    @Override
    public Optional<Match> findById(Long id) {
        return repository.findById(id);
    }
}
