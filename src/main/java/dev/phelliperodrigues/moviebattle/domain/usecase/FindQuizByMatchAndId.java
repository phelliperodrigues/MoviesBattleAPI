package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.MatchRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindQuizByMatchAndId {
    private final MatchRepositoryFacade matchRepositoryFacade;

    public Match execute(Long matchId, Integer quizId) {
        var match = matchRepositoryFacade.findById(matchId);
        return match.map(m -> {
                    m.setQuizzes(List.of(m.getNextQuiz(quizId).orElseThrow()));
                    return m;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Not content next quiz"));
    }
}
