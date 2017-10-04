package com.caysever.aaghub.service.user;

import com.caysever.aaghub.client.GithubClient;
import com.caysever.aaghub.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubUserServiceTest {

    @Autowired
    GithubClient githubClient;

    @Test
    public void should_get_github_user_profile() throws Exception {
        // given
        String userName = "alicanakkus";

        // when
        User userProfile = githubClient.getUserProfile(userName);

        // then
        assertNotNull(userName);
        assertEquals("Alican Akkuş", userProfile.getName());
        assertEquals("@iyzico", userProfile.getCompany().trim());
        assertEquals("http://www.alicanakkus.com", userProfile.getBlog());
    }

    @Test
    public void should_not_get_github_user_profile_when_username_is_null_or_empty() throws Exception {
        // given
        String userName = "";

        // when
        Throwable throwable = catchThrowable(() -> githubClient.getUserProfile(userName));

        // then
        assertNotNull(throwable);
        assertEquals("User name could not be null or empty!", throwable.getMessage());
    }

}