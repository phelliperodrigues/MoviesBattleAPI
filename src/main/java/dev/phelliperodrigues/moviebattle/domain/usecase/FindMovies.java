package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.MovieRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class FindMovies {

    private final MovieRepositoryFacade repositoryFacade;

    public List<Movie> execute(Match match) {
        List<Movie> movies = repositoryFacade.findAll();
        Random random = new Random();
        Set<Movie> result = new HashSet<>();

        while (result.size() < 2) {
            var movie1 = movies.get(random.nextInt(movies.size()));
            var movie2 = movies.get(random.nextInt(movies.size()));
            result.add(movie1);
            result.add(movie2);
        }


        return result.stream().toList();
    }
}
