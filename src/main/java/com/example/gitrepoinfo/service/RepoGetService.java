package com.example.gitrepoinfo.service;

import com.example.gitrepoinfo.model.RepositoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepoGetService {

    private final WebClient webClient;

    public Optional<List<RepositoryInfo>> getListRepository(String userName) {
        Optional<RepositoryInfo[]> repos = getRepo(userName);
        if (repos.isPresent()) {
            RepositoryInfo[] block = repos.get();
            List<RepositoryInfo> list = Arrays.stream(block).toList();
            return Optional.of(list);
        }
        return Optional.empty();
    }

    private Optional<RepositoryInfo[]> getRepo(String userName) {
        try {
            return webClient
                    .get()
                    .uri("/users/" + userName + "/repos")
                    .retrieve()
                    .bodyToMono(RepositoryInfo[].class)
                    .blockOptional();
        } catch (WebClientResponseException.NotFound e) {
            return Optional.empty();
        }
    }

}
