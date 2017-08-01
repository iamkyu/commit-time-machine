package io.iamkyu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * @author Kj Nam
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubCommitter {

    @JsonProperty("date")
    private OffsetDateTime date;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
}
