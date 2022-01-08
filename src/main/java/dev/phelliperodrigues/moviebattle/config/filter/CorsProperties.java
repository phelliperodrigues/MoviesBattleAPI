package dev.phelliperodrigues.moviebattle.config.filter;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

@Data
@ConfigurationProperties(prefix = "cors")
@Configuration
public class CorsProperties implements InitializingBean {

    private final List<String> headers = new ArrayList<>();
    private final List<String> protectedPaths = new ArrayList<>();
    private String[] protectedPathsArray;
    private String errorPath = "/error";
    private String commaDelimitedHeaders;
    private String publicPath;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.commaDelimitedHeaders = collectionToCommaDelimitedString(this.headers).toUpperCase();
        this.protectedPathsArray = this.protectedPaths.toArray(new String[0]);
    }
}