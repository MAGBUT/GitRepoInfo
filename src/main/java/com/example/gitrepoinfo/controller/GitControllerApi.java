package com.example.gitrepoinfo.controller;

import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import com.example.gitrepoinfo.exception.ExceptionMessage;
import com.example.gitrepoinfo.service.GetFullInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/git")
@RequiredArgsConstructor
public class GitControllerApi {
    private final GetFullInfoService getFullInfoService;

    @GetMapping(value = "/user/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRepos(@PathVariable String userName){
        Optional<FullInfoOwnerDto> userInfo = getFullInfoService.getUserInfo(userName);
        if (userInfo.isPresent()){
            return ResponseEntity.ok().body(userInfo);
        }
        ExceptionMessage message = ExceptionMessage.builder().status(404).Message("WRONG USER NAME, DOESN'T EXIST").build();
        return ResponseEntity.status(404).body(message);
    }

    @GetMapping(value = "/user/{userName}",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> badAccept(@PathVariable String userName){
        ExceptionMessage message = ExceptionMessage.builder().status(406).Message("Wrong accept header,application/json required").build();
        return ResponseEntity.status(406).body(message);
    }
}
