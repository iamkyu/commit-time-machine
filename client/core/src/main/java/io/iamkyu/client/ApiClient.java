package io.iamkyu.client;

import io.iamkyu.client.config.HostProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.netty.http.client.HttpClient;
import reactor.util.annotation.Nullable;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ApiClient {
    protected final WebClient webClient;

    public ApiClient(WebClient.Builder builder, HostProperties properties) {
        this.webClient = builder.uriBuilderFactory(uriBuilder(properties.getProtocol(), properties.getUrl()))
                .defaultHeaders(defaultHeadersConsumer(properties.getHeaders()))
                .clientConnector(new ReactorClientHttpConnector(httpClient(properties)))
                .build();
    }

    private UriBuilderFactory uriBuilder(String protocol, String url) {
        return uriBuilder(protocol, url, null);
    }

    private UriBuilderFactory uriBuilder(String protocol, String url, @Nullable String port) {
        return new DefaultUriBuilderFactory(UriComponentsBuilder
                .newInstance()
                .scheme(protocol)
                .host(url)
                .port(StringUtils.hasText(port) ? port : null));
    }

    private Consumer<HttpHeaders> defaultHeadersConsumer(Map<String, String> headers) {
        return defaultHeaders -> headers.entrySet()
                .forEach(e -> defaultHeaders.add(e.getKey(), e.getValue()));
    }

    private HttpClient httpClient(HostProperties properties) {
        return HttpClient.create()
                .tcpConfiguration(client ->
                        client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.getConnectionTimeout())
                                .doOnConnected(conn -> conn
                                        .addHandlerLast(new ReadTimeoutHandler(properties.getSocketTimeout(), TimeUnit.MILLISECONDS))
                                        .addHandlerLast(new WriteTimeoutHandler(properties.getSocketTimeout(), TimeUnit.MILLISECONDS))
                                ));
    }
}
