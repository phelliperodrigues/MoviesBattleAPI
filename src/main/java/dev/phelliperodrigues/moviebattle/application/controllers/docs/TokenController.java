package dev.phelliperodrigues.moviebattle.application.controllers.docs;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static dev.phelliperodrigues.moviebattle.application.controllers.utils.UrlMapping.AUTH_API;
import static dev.phelliperodrigues.moviebattle.application.controllers.utils.UrlMapping.REVOKE_TOKEN_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Token Auth Api", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequestMapping(value = AUTH_API)
public interface TokenController {

    @ApiOperation(value = "Revoke token security to logout", nickname = "revoke",
            tags = {"Token Auth Api"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 204, message = "No Content"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden")
            }
    )
    @DeleteMapping(REVOKE_TOKEN_URI)
    void revoke(HttpServletRequest req, HttpServletResponse resp);
}
