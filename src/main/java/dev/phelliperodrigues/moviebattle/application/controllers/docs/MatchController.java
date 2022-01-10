package dev.phelliperodrigues.moviebattle.application.controllers.docs;

import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchQuizResponse;
import dev.phelliperodrigues.moviebattle.application.domain.responses.MatchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static dev.phelliperodrigues.moviebattle.application.controllers.utils.UrlMapping.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Match Api", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequestMapping(value = MATCHER_API)
public interface MatchController {

    @ApiOperation(value = "Start a new match", nickname = "start",
            tags = {"Match Api"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Accept"),
                    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden")
            }
    )
    @PostMapping(START_MATCH_URI)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<MatchResponse> start(UriComponentsBuilder builder);

    @ApiOperation(value = "Get Quiz by match id and quiz id", nickname = "getQuiz",
            tags = {"Match Api"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Accept"),
                    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden")
            }
    )
    @GetMapping(QUIZ_MATCH_URI)
    ResponseEntity<MatchQuizResponse> getQuiz(UriComponentsBuilder builder,
                                              @PathVariable Long matchId,
                                              @PathVariable Integer quizId);
}
