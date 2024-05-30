package com.kaybee.auth.security.jwt;

import com.kaybee.auth.security.jwt.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class JwtAuthService {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  private JwtHelper jwtHelper;

  public String login(JwtRequest jwtRequest) {
    doAuthenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
    String token = this.jwtHelper.generateToken(userDetails);
    return token;
  }

  private void doAuthenticate(String username, String password) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        username, password);
    try {
      authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException(" Invalid Username or Password !!");
    }
  }
  
}
