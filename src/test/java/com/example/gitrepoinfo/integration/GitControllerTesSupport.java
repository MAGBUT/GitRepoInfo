package com.example.gitrepoinfo.integration;

import com.example.gitrepoinfo.dto.FullInfoOwnerDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface GitControllerTesSupport {
    RequestSpecification requestSpecification();

    default FullInfoOwnerDto getRepos() {
        Response response = requestSpecification()
                .get("api/git/user/MAGBUT")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .extract()
                .response();

        return response.as(FullInfoOwnerDto.class);
    }
}
