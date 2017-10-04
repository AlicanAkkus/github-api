package com.caysever.aaghub.service.repo;

import com.caysever.aaghub.client.GithubClient;
import com.caysever.aaghub.model.Repo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRepoServiceTest {

    @Autowired
    private GithubClient githubClient;

    @Test
    public void getRepositoryDetails() throws Exception {
        // given
        String owner = "AlicanAkkus";
        String repository = "java8";

        Repo repositoryDetails = githubClient.getRepositoryDetails(owner, repository);
        assertNotNull(repositoryDetails);
        assertEquals(owner + "/" + repository, repositoryDetails.getFullName());
    }

}