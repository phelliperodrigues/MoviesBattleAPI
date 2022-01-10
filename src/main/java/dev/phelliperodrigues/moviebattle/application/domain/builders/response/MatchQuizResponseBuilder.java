package dev.phelliperodrigues.moviebattle.application.domain.builders.response;

import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchQuizResponse;
import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchResponse;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Quiz;
import dev.phelliperodrigues.moviebattle.shared.enuns.MatchStatus;

public class MatchQuizResponseBuilder {

    private MatchQuizResponseBuilder(){
        throw new IllegalStateException("MatchQuizResponseBuilder is a builder class");
    }

    public static MatchQuizResponse build(Match match){

        return MatchQuizResponse.builder()
                .matchId(match.getId())
                .quizId(match.getQuizzes().stream().findFirst().map(Quiz::getId).orElseThrow().getSequence())
                .build();
    }
}
