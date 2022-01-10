package dev.phelliperodrigues.moviebattle.application.controllers.utils;

import org.springframework.security.core.context.SecurityContextHolder;


public final class BaseWS {
    public static String getAuthenticatedUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
