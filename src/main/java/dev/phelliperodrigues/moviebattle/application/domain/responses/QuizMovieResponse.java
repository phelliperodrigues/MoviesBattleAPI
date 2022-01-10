package dev.phelliperodrigues.moviebattle.application.domain.responses;

import dev.phelliperodrigues.moviebattle.shared.enuns.QuizMovieNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizMovieResponse {
    private String title;
    private String imdbId;
    private String poster;
    private QuizMovieNumber movie;
}
