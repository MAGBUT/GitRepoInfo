package com.example.gitrepoinfo.service;

import com.example.gitrepoinfo.model.Branch;
import com.example.gitrepoinfo.model.RepositoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchGetService {

    private final WebClient webClient;

    public Optional<List<Branch>> getListBranch(String userName, String repoName) {
        Flux<Branch> repos = getBranch(userName, repoName);
        if (repos != null) {
            List<Branch> branchList = repos.collectList()
                    .block();
            return Optional.of(branchList);
        }
        return Optional.empty();
    }

    private Flux<Branch> getBranch(String userName,String repoName) {
        try {
            return webClient
                    .get()
                    .uri("/repos/" + userName + "/"+repoName+"/branches")
                    .retrieve()
                    .bodyToFlux(Branch.class);
        } catch (Exception e) {
            return null;
        }
    }
}
