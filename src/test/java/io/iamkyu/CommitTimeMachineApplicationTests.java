package io.iamkyu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.iamkyu.model.GithubResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommitTimeMachineApplicationTests {

    @Test
    public void github_api_health_check() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.cloak-preview");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        URI targetUrl = UriComponentsBuilder
                .fromUriString("https://api.github.com/search/commits?q=author:iamkyu+committer-date:2017-07-16")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity.ok(restTemplate.exchange(targetUrl, HttpMethod.GET, entity, Map.class));
    }

    @Test
    public void objectMappingTest() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.cloak-preview");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        URI targetUrl = UriComponentsBuilder
                .fromUriString("https://api.github.com/search/commits?q=author:iamkyu+committer-date:2017-07-21")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(targetUrl, HttpMethod.GET, entity, String.class);

        String result = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        GithubResponse githubResponse = mapper.readValue(result, GithubResponse.class);
        // OffsetDateTime date = githubResponse.getItems().get(0).getCommit().getCommitter().getDate();
        // System.out.println(date);
    }
}
