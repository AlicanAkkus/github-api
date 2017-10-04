package com.caysever.aaghub.client;

import com.caysever.aaghub.model.Repo;
import com.caysever.aaghub.model.User;
import com.caysever.aaghub.service.repo.GithubRepoService;
import com.caysever.aaghub.service.user.GithubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubClient {

    @Autowired
    private GithubUserService githubUserService;
    @Autowired
    private GithubRepoService githubRepoService;

    public Repo getRepositoryDetails(String owner, String repository) {
        return githubRepoService.getRepositoryDetails(owner, repository);
    }

    public User getUserProfile(String userName) {
        return githubUserService.getUserProfile(userName);
    }
}
