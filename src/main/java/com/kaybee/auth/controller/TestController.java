package com.kaybee.auth.controller;

//import com.kaybee.auth.cognitoSimple.CognitoAuthService;

import com.kaybee.auth.security.jwt.JwtAuthService;
import com.kaybee.auth.security.jwt.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//  @Autowired
//  CognitoAuthService cognitoAuthService;
//  @GetMapping(path = "/token")
//  public String getToken() {
//    return cognitoAuthService.getToken("kallol1", "kallol1Password@");
//  }

  @Autowired
  JwtAuthService jwtAuthService;

  @GetMapping(path = "/ins")
  public String getIns() {
    return "success";
  }

  @PostMapping("/login")
  public String login(@RequestBody JwtRequest jwtRequest) {
    return jwtAuthService.login(jwtRequest);
  }

}
