package com.example.demo1.controller;

import com.example.demo1.dto.AccessTokenDTO;
import com.example.demo1.dto.GithubUser;
import com.example.demo1.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("b906c522bcacdb612e5c");
        accessTokenDTO.setClient_secret("81b435ea95238e130b4a62d5508c4a24fb6ee38b");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user == null)
            System.out.println("null");
        else
            System.out.println(user);
        return "index";
    }
}
