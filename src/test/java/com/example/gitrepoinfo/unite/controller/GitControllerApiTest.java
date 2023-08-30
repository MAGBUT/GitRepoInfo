package com.example.gitrepoinfo.unite.controller;

import com.example.gitrepoinfo.controller.GitControllerApi;
import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import com.example.gitrepoinfo.service.GetFullInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ExtendedModelMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Importy dotyczące Mockito i JUnit
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GitControllerApiTest {

    @InjectMocks
    private GitControllerApi gitControllerApi;

    @Mock
    private GetFullInfoService getFullInfoService;

    @Test
    void getRepos(){
            Optional<FullInfoOwnerDto> fullInfoOwnerDto = Optional.of(FullInfoOwnerDto.builder().build());
            String userName = "MAGBUT";

            when(getFullInfoService.getUserInfo(userName)).thenReturn(fullInfoOwnerDto);


        ResponseEntity<?> response = gitControllerApi.getRepos(userName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(fullInfoOwnerDto, response.getBody());
        verify(getFullInfoService, times(1)).getUserInfo(userName);


    }
}
