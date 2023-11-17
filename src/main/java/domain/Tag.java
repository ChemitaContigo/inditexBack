package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
