package com.example.gitrepoinfo.service;

import com.example.gitrepoinfo.dto.BranchInfoDto;
import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import com.example.gitrepoinfo.dto.ReposInfoDto;
import com.example.gitrepoinfo.dto.map.BrunchInfoDtoMapper;
import com.example.gitrepoinfo.dto.map.FullInfoOwnerDtoMapper;
import com.example.gitrepoinfo.dto.map.ReposInfoDtoMapper;
import com.example.gitrepoinfo.model.Branch;
import com.example.gitrepoinfo.model.RepositoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetFullInfoService {

    private final RepoGetService repoGetService;
    private final BranchGetService branchGetService;
    private final FullInfoOwnerDtoMapper fullInfoOwnerDtoMapper;
    private final ReposInfoDtoMapper reposInfoDtoMapper;
    private final BrunchInfoDtoMapper brunchInfoDtoMapper;

    public Optional<FullInfoOwnerDto> getUserInfo(String userName){
        Optional<List<ReposInfoDto>> allReposFromUser = getAllReposFromUser(userName);
        if (allReposFromUser.isPresent()){
            FullInfoOwnerDto fullInfoOwnerDto = fullInfoOwnerDtoMapper.map(userName, allReposFromUser.get());
            return Optional.of(fullInfoOwnerDto);
        }
        return Optional.empty();
    }

    private Optional<List<ReposInfoDto>> getAllReposFromUser(String userName){
        Optional<List<RepositoryInfo>> listRepository = repoGetService.getListRepository(userName);
        if (listRepository.isPresent()){
            List<ReposInfoDto> list = listRepository.get().stream()
                    .filter(repositoryInfo -> !repositoryInfo.isFork())
                    .map(repositoryInfo -> repoMap(userName, repositoryInfo))
                    .toList();
            return Optional.of(list);
        }
        return Optional.empty();
    }

    private ReposInfoDto repoMap(String userName, RepositoryInfo repositoryInfo) {
        return reposInfoDtoMapper.map(repositoryInfo, getAllBranch(userName, repositoryInfo.getName()));
    }

    private List<BranchInfoDto> getAllBranch(String userName,String repositoryName){
        Optional<List<Branch>> listBranch = branchGetService.getListBranch(userName, repositoryName);
        if (listBranch.isPresent()){
            List<BranchInfoDto> list = listBranch.get().stream()
                    .map(brunchInfoDtoMapper::map)
                    .toList();
            return list;
        }
        return new ArrayList<>();
    }
}
