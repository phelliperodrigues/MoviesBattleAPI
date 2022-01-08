package dev.phelliperodrigues.moviebattle.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@Profile({"dev"})
public class SwaggerConfig {

    private static final String TITLE = "Movies Battle Game APIs";
    private static final String VERSION = "1.0";
    private static final String PATHS_API = "/api/.*";
    public static final String APP_SWAGGER_HOST = "app.swagger.host";

    @Bean
    public Docket documentation(Environment env) {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(env.getRequiredProperty(APP_SWAGGER_HOST))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex(PATHS_API))
                .build()
                .apiInfo(apiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(basicAuthScheme()));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(List.of(basicAuthReference()))
                .build();
    }


    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description("REST API for a card game-style application, where two movies will be informed and the player must hit the one with the best rating on IMDB.")
                .contact(new Contact("Phellipe Rodrigues", "https://phelliperodrigues.dev", "phelliperodrigues.dev@gmail.com"))
                .version(VERSION)
                .build();
    }
}