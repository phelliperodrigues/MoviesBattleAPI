package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Movie;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Quiz;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.id.QuizId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindQuizToMatchId {

    private final FindMovies findMovies;

    public Quiz execute(Match match) {
        List<Movie> movies = findMovies.execute(match);
        return Quiz.builder()
                .id(QuizId.builder()
                        .match(match)
                        .sequence(match.getQuizzes() != null ? match.getQuizzes().size() + 1 : 1)
                        .build())
                .movieOne(movies.get(0))
                .movieTwo(movies.get(1))
                .build();

    }
}
