package io.iamkyu.client.github.config;

import io.iamkyu.client.github.GithubApiClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(GithubClientProperties.class)
public class GithubClientConfig {

    @Bean
    public GithubApiClient githubApiClient(WebClient.Builder builder, GithubClientProperties properties) {
        return new GithubApiClient(builder, properties.getGithubApi());
    }
}
