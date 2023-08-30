package com.example.gitrepoinfo.dto.map;

import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import com.example.gitrepoinfo.dto.ReposInfoDto;
import com.example.gitrepoinfo.model.Branch;
import com.example.gitrepoinfo.model.RepositoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FullInfoOwnerDtoMapper {
    public FullInfoOwnerDto map (String userName, List<ReposInfoDto> repos){
        return FullInfoOwnerDto.builder()
                .login(userName)
                .repositories(repos)
                .build();
    }
}
