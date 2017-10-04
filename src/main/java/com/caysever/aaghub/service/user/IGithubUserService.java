package com.caysever.aaghub.service.user;

import com.caysever.aaghub.model.Repo;
import com.caysever.aaghub.model.User;

import java.util.List;

public interface IGithubUserService {

    String USER_PROFILE_URL = "https://api.github.com/users/{name}";
    String USER_FOLLOWERS_URL = "https://api.github.com/users/{name}/followers";
    String USER_FOLLOWING_URL = "https://api.github.com/users/{name}/following";
    String USER_STARRED_REPOS_URL = "https://api.github.com/users/{name}/starred";

    User getUserProfile(String userName);

    List<User> getUserFollowers(User user);

    List<User> getUserFollowing(User user);

    List<Repo> getStarredRepos(User user);
}
