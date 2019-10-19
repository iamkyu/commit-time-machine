package io.iamkyu.client.github;

import io.iamkyu.client.ApiClient;
import io.iamkyu.client.config.HostProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public class GithubApiClient extends ApiClient {
    public GithubApiClient(WebClient.Builder builder, HostProperties properties) {
        super(builder, properties);
    }

    public void call() {
        Mono<String> stringMono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/commits")
                        .queryParam("q", "author:iamkyu")
                        .build())
                .retrieve()
                .bodyToMono(String.class);

        stringMono.subscribe(s -> {
            System.out.println(s);
        });
    }
}
