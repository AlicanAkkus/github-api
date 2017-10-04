package com.caysever.aaghub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Repo {

    private Long id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private User owner;

}
