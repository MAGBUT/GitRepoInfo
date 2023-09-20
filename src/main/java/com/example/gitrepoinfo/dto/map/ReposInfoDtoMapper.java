package com.example.gitrepoinfo.dto.map;

import com.example.gitrepoinfo.dto.BranchInfoDto;
import com.example.gitrepoinfo.dto.ReposInfoDto;
import com.example.gitrepoinfo.model.RepositoryInfo;
import com.example.gitrepoinfo.service.BranchGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReposInfoDtoMapper {
    private final BranchGetService branchGetService;
    public ReposInfoDto map(RepositoryInfo repo, List<BranchInfoDto> brunch){
        return ReposInfoDto.builder()
                .name(repo.name())
                .branches(brunch)
                .build();
    }
}
