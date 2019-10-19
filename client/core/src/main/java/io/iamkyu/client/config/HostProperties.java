package io.iamkyu.client.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class HostProperties {
    private static final String DEFAULT_PROTOCOL = "http";
    private static final Integer DEFAULT_CONNECTION_TIMEOUT = 1_000;
    private static final Integer DEFAULT_SOCKET_TIMEOUT = 1_000;


    private String protocol = DEFAULT_PROTOCOL;
    private String url;
    private Map<String, String> headers = new HashMap<>();

    private Integer connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private Integer socketTimeout = DEFAULT_SOCKET_TIMEOUT;
}
