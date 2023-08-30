package com.example.gitrepoinfo.integration;
import com.github.tomakehurst.wiremock.WireMockServer;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.MediaType;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public interface GitControllerStubSupport {


    default void stubForRepo(final WireMockServer wireMockServer){
        wireMockServer.stubFor(WireMock.get("/users/MAGBUT/repos")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/MAGBUTUser.json")));
    }

    default void stubForBranch1(final WireMockServer wireMockServer){
        wireMockServer.stubFor(WireMock.get("/repos/MAGBUT/Przychodnia/branches")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/PrzychodniaBranch.json")));
    }

    default void stubForBranch2(final WireMockServer wireMockServer){
        wireMockServer.stubFor(WireMock.get("/repos/MAGBUT/GitRepoInfo/branches")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/GitRepoInfoBranch.json")));
    }

}
