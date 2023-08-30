package com.example.gitrepoinfo.integration;

import com.example.gitrepoinfo.config.RestAssureIntegrationTestBase;
import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GitControllerApiIT
        extends RestAssureIntegrationTestBase
        implements GitControllerTesSupport, GitControllerStubSupport {

    @Test
    void getsQuestionApi() {

        stubForRepo(wireMockServer);
        stubForBranch1(wireMockServer);
        stubForBranch2(wireMockServer);

        FullInfoOwnerDto repos = getRepos();

        assertThat(repos.getRepositories()).hasSize(2);
    }


}
