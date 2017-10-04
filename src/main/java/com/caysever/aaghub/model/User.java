package com.caysever.aaghub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class User {

    private Long id;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("public_repos")
    private Integer publicRepos;
    @JsonProperty("public_gists")
    private Integer publicGists;
    private Integer followersCount;
    private Integer followingCount;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    private String login;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("followers_url")
    private String followersUrl;
    @JsonProperty("following_url")
    private String followingUrl;
    @JsonProperty("gists_url")
    private String gistsUrl;
    @JsonProperty("starred_url")
    private String starredUrl;
    private String type;

    @JsonIgnore
    private List<User> followers;
    @JsonIgnore
    private List<User> following;
    @JsonIgnore
    private List<Repo> starredRepos;
}
