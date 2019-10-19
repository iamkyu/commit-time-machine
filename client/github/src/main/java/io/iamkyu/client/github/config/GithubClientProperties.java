package io.iamkyu.client.github.config;

import io.iamkyu.client.config.HostProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("hosts.github")
public class GithubClientProperties {
    private HostProperties githubApi;
}
