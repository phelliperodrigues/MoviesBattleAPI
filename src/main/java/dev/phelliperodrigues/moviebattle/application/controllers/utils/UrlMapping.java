package dev.phelliperodrigues.moviebattle.application.controllers.utils;

public interface UrlMapping {
    String ROOT_URI_V1 = "/api/v1";

    String USER_API = ROOT_URI_V1 + "/users";

    String AUTH_API = ROOT_URI_V1 + "/tokens";
    String REVOKE_TOKEN_URI =  "/revoke";

    String GAME_API = ROOT_URI_V1 + "/games";
    String RANK_URI =  "/ranks/top/{value}";
    String START_GAME_URI =  "/start";
    String END_GAME_URI =  "/end";
    String CHOICE_API =  "/choices";

}
