package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.facades;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.MovieRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Movie;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieRepositoryFacadeImpl implements MovieRepositoryFacade {
    private final MovieRepository repository;
    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }
}
