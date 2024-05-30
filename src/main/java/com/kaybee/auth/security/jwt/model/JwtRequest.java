package com.kaybee.auth.security.jwt.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {
  String username;
  String password;

}
