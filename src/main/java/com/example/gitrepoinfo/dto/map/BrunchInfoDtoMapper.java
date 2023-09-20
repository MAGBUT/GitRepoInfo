package com.example.gitrepoinfo.dto.map;

import com.example.gitrepoinfo.dto.BranchInfoDto;
import com.example.gitrepoinfo.model.Branch;
import org.springframework.stereotype.Service;

@Service
public class BrunchInfoDtoMapper {
    public BranchInfoDto map(Branch branch){
        return BranchInfoDto.builder()
                .name(branch.name())
                .sha(branch.commit().sha())
                .build();
    }
}
