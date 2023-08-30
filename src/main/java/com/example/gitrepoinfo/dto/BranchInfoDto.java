package com.example.gitrepoinfo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchInfoDto {
    private String name;
    private String sha;
}
