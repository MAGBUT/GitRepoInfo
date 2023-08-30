package com.example.gitrepoinfo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReposInfoDto {
    private String name;
    private List<BranchInfoDto> branches;
}
