# GITREPOINFO
## General Info
The project aims to download information about individual repositories and create the core information
just like
* username
* public repositories that are not forks
* branches of individual repositories
* sha latest commits
  
The project was created to learn and consolidate knowledge.

## Technologies
* Java 17
* SpringBoot 3.1.3
* Lombok
* WireMock 2.27.2
* Rest Assured 5.3.0
* Mockito 3.11.0

## Code Example
### Request
HTTP GET (http://localhost:8080)/api/git/user/{userName}
### ResponseIfUserExist
-H accept application/json
```
{
    "login": "MAGBUT",
    "repositories": [
        {
            "name": "GitRepoInfo",
            "branches": [
                {
                    "name": "master",
                    "sha": "cdf54bc28b5bde0a756469e39f0d5097b2f6dd37"
                }
            ]
        },
        {
            "name": "Przychodnia",
            "branches": [
                {
                    "name": "main",
                    "sha": "3b758dcdd338eda1f2cf2d42b2177314c2cccfe9"
                },
                {
                    "name": "master",
                    "sha": "a98810449267d90d77daaa91c3b545e43f9698c3"
                }
            ]
        }
    ]
}
```
### ResponseIfUserNotExist
-H accept application/json
```
{
    "status": 404,
    "message": "WRONG USER NAME, DOESN'T EXIST"
}
```
### ResponseIfWrrongAcceptFormat
-H accept application/xml
```
<ExceptionMessage>
    <status>406</status>
    <message>Wrong accept header,application/json required</message>
</ExceptionMessage>
```

   
