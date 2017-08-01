package io.iamkyu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Kj Nam
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubCommit {

    @JsonProperty("committer")
    private GithubCommitter committer;

    @JsonProperty("message")
    private String message;
}
