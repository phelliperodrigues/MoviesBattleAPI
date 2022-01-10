package dev.phelliperodrigues.moviebattle.domain.interfaces.facade;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Movie;

import java.util.List;

public interface MovieRepositoryFacade {
    List<Movie> findAll();
}
