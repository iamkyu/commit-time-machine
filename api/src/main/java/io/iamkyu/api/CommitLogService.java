package io.iamkyu.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommitLogService {
//    public GithubResponse findByDate(String date) throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/vnd.github.cloak-preview");
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//
//        URI targetUrl = UriComponentsBuilder
//                .fromUriString(String.format("https://api.github.com/search/commits?q=author:iamkyu+committer-date:%s", date))
//                .build()
//                .toUri();
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate
//                .exchange(targetUrl, HttpMethod.GET, entity, String.class);
//
//        String responseBody = responseEntity.getBody();
//
//        ObjectMapper mapper = new ObjectMapper();
//        GithubResponse githubResponse = mapper.readValue(responseBody, GithubResponse.class);
//
//        return githubResponse;
//    }
}
