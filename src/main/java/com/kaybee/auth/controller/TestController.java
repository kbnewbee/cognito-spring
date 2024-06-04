package com.kaybee.auth.controller;

import com.kaybee.auth.cognitoCustom.CognitoAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  /**
   * Cognito custom implementation
   */
  @Autowired
  CognitoAuthService cognitoAuthService;
  @GetMapping(path = "/token")
  public String getToken() {
    return cognitoAuthService.authenticateAndGetToken("kallol1", "kallol1Password@");
  }



  /**
   * Cognito simple implementation
   */
//  @Autowired
//  CognitoAuthService cognitoAuthService;
//  @GetMapping(path = "/token")
//  public String getToken() {
//    return cognitoAuthService.getToken("kallol1", "kallol1Password@");
//  }

  /**
   * Custom JWT implementation
   */
//  @Autowired
//  JwtAuthService jwtAuthService;
//  @PostMapping("/login")
//  public String login(@RequestBody JwtRequest jwtRequest) {
//    return jwtAuthService.login(jwtRequest);
//  }

  /**
   * needs to be secured only this api
   * @return
   */
  @GetMapping(path = "/ins")
  public String getIns() {
    return "success";
  }

}
