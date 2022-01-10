package dev.phelliperodrigues.moviebattle.application.domain.builders.response;

import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchResponse;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Quiz;
import dev.phelliperodrigues.moviebattle.shared.enuns.MatchStatus;

import java.util.Collections;
import java.util.Comparator;

public class MatchResponseBuilder {
    private MatchResponseBuilder(){
        throw new IllegalStateException("MatchResponseBuilder is a builder class");
    }

    public static MatchResponse build(Match match){

        return MatchResponse.builder()
                .matchId(match.getId())
                .quizId(match.getQuizzes().stream().findFirst().map(Quiz::getId).orElseThrow().getSequence())
                .status(match.getPlaying() ? MatchStatus.START : MatchStatus.END)
                .build();
    }
}
