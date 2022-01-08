package dev.phelliperodrigues.moviebattle.application.controllers.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("api")
public class ApiProperty {

    private final Security security = new Security();

    @Data
    public static class Security {
        private boolean enableHttps;
    }
}
