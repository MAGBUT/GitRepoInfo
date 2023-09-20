package com.example.gitrepoinfo.model;

import lombok.Data;

//@Data
public record RepositoryInfo(String name, boolean fork, Owner owner) {
//    private String name;
//    private boolean fork;
//    private Owner owner;
}
