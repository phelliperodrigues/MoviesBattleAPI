package dev.phelliperodrigues.moviebattle.application.controllers;

import dev.phelliperodrigues.moviebattle.application.controllers.docs.MatchController;
import dev.phelliperodrigues.moviebattle.application.domain.builders.response.MatchQuizResponseBuilder;
import dev.phelliperodrigues.moviebattle.application.domain.builders.response.MatchResponseBuilder;
import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchQuizResponse;
import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchResponse;
import dev.phelliperodrigues.moviebattle.domain.usecase.EndGame;
import dev.phelliperodrigues.moviebattle.domain.usecase.FindQuizByMatchAndId;
import dev.phelliperodrigues.moviebattle.domain.usecase.StartMatch;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import static dev.phelliperodrigues.moviebattle.application.controllers.utils.BaseWS.getAuthenticatedUsername;
import static dev.phelliperodrigues.moviebattle.application.controllers.utils.UrlMapping.QUIZ_MATCH_URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchControllerImpl implements MatchController {

    private final StartMatch startMatch;
    private final FindQuizByMatchAndId findQuizByMatchAndId;
    private final EndGame endGame;

    @Override
    public ResponseEntity<MatchResponse> start(UriComponentsBuilder builder) {
        var username = getAuthenticatedUsername();
        MatchResponse response = MatchResponseBuilder.build(startMatch.execute(username));
        var location = builder.replacePath(QUIZ_MATCH_URI).buildAndExpand(response.getMatchId(), response.getQuizId()).toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Override
    public ResponseEntity<MatchQuizResponse> getQuiz(UriComponentsBuilder builder, Long matchId, Integer quizId) {
        MatchQuizResponseBuilder.build(findQuizByMatchAndId.execute(matchId, quizId));
        return ResponseEntity.ok().body(null);
    }
}
