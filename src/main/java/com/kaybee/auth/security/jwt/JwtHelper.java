package com.kaybee.auth.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
  private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Date getExpirationFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsFunction) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsFunction.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationFromToken(token);
    return expiration.before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
    HashMap<String, Object> claims = new HashMap<>();
    return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).signWith(
            SignatureAlgorithm.HS512, secret).compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

}
