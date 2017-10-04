package com.caysever.aaghub.service.repo;

import com.caysever.aaghub.model.Repo;

public interface IGithubRepoService {

    String GITHUB_REPO_URL = "https://api.github.com/repos/{owner}/{repository}";

    Repo getRepositoryDetails(String owner, String repository);

}
