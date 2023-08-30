package com.example.gitrepoinfo.model;

import lombok.Data;

@Data
public class RepositoryInfo {
    private String name;
    private boolean fork;
    private Owner owner;
}
