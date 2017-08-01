package io.iamkyu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import groovy.util.logging.Slf4j;
import io.iamkyu.model.GithubResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author Kj Nam
 */
@Slf4j
@Service
public class CommitLogService {

    public GithubResponse findByDate(String date) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.cloak-preview");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        URI targetUrl = UriComponentsBuilder
                .fromUriString(String.format("https://api.github.com/search/commits?q=author:iamkyu+committer-date:%s", date))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(targetUrl, HttpMethod.GET, entity, String.class);

        String responseBody = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(new JavaTimeModule());
        GithubResponse githubResponse = mapper.readValue(responseBody, GithubResponse.class);

        return githubResponse;
    }
}
