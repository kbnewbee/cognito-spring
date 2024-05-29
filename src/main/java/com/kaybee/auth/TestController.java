package com.kaybee.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  CognitoAuthService cognitoAuthService;

  @GetMapping(path = "/ins")
  public String getUser() {
    return "success";
  }

  @GetMapping(path = "/tok")
  public String getToken() {
    return cognitoAuthService.getToken("kallol1", "kallol1Password@");
  }
}
