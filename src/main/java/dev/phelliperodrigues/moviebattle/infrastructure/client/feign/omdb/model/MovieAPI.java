package dev.phelliperodrigues.moviebattle.infrastructure.client.feign.omdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieAPI {
    private String imdbID;
    private long imdbVotes;
    private double imdbRating;

    public Double getScoreTotal(){
        return this.imdbRating * this.imdbVotes;
    }
}
