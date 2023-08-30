package com.example.gitrepoinfo;

import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import com.example.gitrepoinfo.model.Branch;
import com.example.gitrepoinfo.model.RepositoryInfo;
import com.example.gitrepoinfo.service.BranchGetService;
import com.example.gitrepoinfo.service.GetFullInfoService;
import com.example.gitrepoinfo.service.RepoGetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class GitRepoInfoApplication {

    public static void main(String[] args) {
         SpringApplication.run(GitRepoInfoApplication.class, args);
    }

}
