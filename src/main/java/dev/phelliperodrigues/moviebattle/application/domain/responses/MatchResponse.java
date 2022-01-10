package dev.phelliperodrigues.moviebattle.application.domain.responses;

import dev.phelliperodrigues.moviebattle.shared.enuns.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponse {
    private MatchStatus status;
    private Integer quizId;
    private Long matchId;
}
