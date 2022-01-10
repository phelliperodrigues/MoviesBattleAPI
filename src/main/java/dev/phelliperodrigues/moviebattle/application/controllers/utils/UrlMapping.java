package dev.phelliperodrigues.moviebattle.application.controllers.utils;

public interface UrlMapping {
    String ROOT_URI_V1 = "/api/v1";

    String USER_API = ROOT_URI_V1 + "/users";

    String AUTH_API = ROOT_URI_V1 + "/tokens";
    String REVOKE_TOKEN_URI =  "/revoke";

    String MATCHER_API = ROOT_URI_V1 + "/matchers";
    String RANK_URI =  "/ranks/top/{value}";
    String START_MATCH_URI =  "/start";
    String END_MATCH_URI =  "/end";
    String QUIZ_MATCH_URI =  "/choices/{matchId}/{quizId}";

}
