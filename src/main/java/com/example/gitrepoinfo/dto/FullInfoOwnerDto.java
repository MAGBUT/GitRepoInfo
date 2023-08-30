package com.example.gitrepoinfo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
public class FullInfoOwnerDto {
    private String login;
    private List<ReposInfoDto> repositories;
}
