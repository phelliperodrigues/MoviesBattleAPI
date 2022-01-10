package dev.phelliperodrigues.moviebattle.infrastructure.client.feign.omdb;

import dev.phelliperodrigues.moviebattle.infrastructure.client.feign.omdb.model.MovieAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class MovieClient {

    private static final String API_URL = "https://www.omdbapi.com/";
    private static final String PARAMS = "?i={imdb}&plot={plot}&apikey={apikey}";
    private static final String API_KEY = "57ec2f6d";

    public Double getScoreTotalByIMDB(String imdb){
        String base = API_URL + PARAMS;
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(base)
                .buildAndExpand(imdb, "full", API_KEY)
                .toUriString();

        try {
            ResponseEntity<MovieAPI> response = restTemplate.getForEntity(url, MovieAPI.class);
            var movie = response.getBody();

            return movie != null ? movie.getScoreTotal() : 0d;
        } catch (RestClientResponseException ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possivel recuperar filme pelo imbdId informado", ex);
        }
    }
}
