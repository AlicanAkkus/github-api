package com.caysever.aaghub.service.repo;

import com.caysever.aaghub.model.Repo;
import com.caysever.aaghub.service.user.GithubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubRepoService implements IGithubRepoService {

    @Autowired
    private RestTemplate client;
    @Autowired
    private GithubUserService githubUserService;

    @Override
    public Repo getRepositoryDetails(String owner, String repository) {
        Assert.notNull(owner, "Owner could not be null or empty!");
        Assert.notNull(repository, "Pepository could not be null or empty!");

        Repo githubRepository = client.getForEntity(GITHUB_REPO_URL, Repo.class, owner, repository).getBody();

        githubRepository.getOwner().setFollowers(githubUserService.getUserFollowers(githubRepository.getOwner()));
        githubRepository.getOwner().setFollowing(githubUserService.getUserFollowing(githubRepository.getOwner()));
        githubRepository.getOwner().setStarredRepos(githubUserService.getStarredRepos(githubRepository.getOwner()));


        return githubRepository;
    }
}
