package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.MatchRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Quiz;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.UserSystem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateMatch {
    private final FindQuizToMatchId findQuizToMatchId;
    private final MatchRepositoryFacade matchRepositoryFacade;

    public Match execute(UserSystem userSystem) {
        matchRepositoryFacade.endsPreviousMatchByPlayerId(userSystem.getPlayer().getId());
         var match = matchRepositoryFacade.save(Match.builder()
                .player(userSystem.getPlayer().playing())
                .score(0.0)
                .playing(true)
                .startDate(LocalDateTime.now())
                .build());
        createQuiz(match);
        return match;

    }

    private void createQuiz(Match match) {
        var quizzes = new ArrayList<Quiz>();
        quizzes.add(findQuizToMatchId.execute(match));
        match.setQuizzes(quizzes);
        matchRepositoryFacade.save(match);
    }
}
