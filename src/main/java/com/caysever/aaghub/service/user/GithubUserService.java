package com.caysever.aaghub.service.user;

import com.caysever.aaghub.model.Repo;
import com.caysever.aaghub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GithubUserService implements IGithubUserService {

    @Autowired
    private RestTemplate client;

    @Override
    public User getUserProfile(String userName) {
        Assert.notNull(userName, "User name could not be null or empty!");

        User githubUser = client.getForEntity(USER_PROFILE_URL, User.class, userName).getBody();
        githubUser.setFollowers(getUserFollowers(githubUser));
        githubUser.setFollowing(getUserFollowing(githubUser));
        githubUser.setStarredRepos(getStarredRepos(githubUser));

        return githubUser;
    }

    @Override
    public List<User> getUserFollowers(User user) {
        Assert.notNull(user, "User could not be null or empty!");
        Assert.notNull(user.getLogin(), "Github user name could not be null or empty!");

        User[] followers = client.getForEntity(USER_FOLLOWERS_URL, User[].class, user.getLogin()).getBody();
        return Arrays.asList(followers);
    }

    @Override
    public List<User> getUserFollowing(User user) {
        Assert.notNull(user, "User could not be null or empty!");
        Assert.notNull(user.getLogin(), "Github user name could not be null or empty!");

        User[] followers = client.getForEntity(USER_FOLLOWING_URL, User[].class, user.getLogin()).getBody();
        return Arrays.asList(followers);
    }

    @Override
    public List<Repo> getStarredRepos(User user) {
        Assert.notNull(user, "User could not be null or empty!");
        Assert.notNull(user.getLogin(), "Github user name could not be null or empty!");

        Repo[] repos = client.getForEntity(USER_STARRED_REPOS_URL, Repo[].class, user.getLogin()).getBody();
        return Arrays.asList(repos);
    }
}
