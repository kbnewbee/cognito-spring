package com.kaybee.auth.cognitoCustom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Instant;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

  private final String issuer = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Bftm8ki6c";
  private CognitoClaimResponse claimResponse;

  /**
   * Decode the JWT token and verify using every possible value
   */
  public boolean validateToken(String token, UserDetails userDetails) {
    /** verifying jwt token using the issuer **/
    this.claimResponse = getAllClaimsFromToken(token);

    // TODO validate expiry, username, clientId and token_use from payload
    String usernameFromToken = getUsernameFromToken();
    if (usernameFromToken != null && userDetails.getUsername().equals(usernameFromToken)) {
      Boolean tokenExpired = isTokenExpired();
      if (tokenExpired) {
        // TODO exception of token expiry
        return false;
      }
      if (!getTokenUseFromToken().equals("access")) {
        // TODO exception of unauthorized
        return false;
      }
    }

    return true;
  }

  /**
   * Map the contents of Response from Token to CognitoClaimResponse.java POJO
   */
  private CognitoClaimResponse getAllClaimsFromToken(String token) {
    JwtDecoder jwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);
    Jwt jwt = jwtDecoder.decode(token);
    Map<String, Object> claims = jwt.getClaims();

    ObjectMapper objectMapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();

    CognitoClaimResponse cognitoClaimResponse = objectMapper.convertValue(claims,
        CognitoClaimResponse.class);
    System.out.println(cognitoClaimResponse);

    return cognitoClaimResponse;
  }

  private Instant getExpirationFromToken() {
    return this.claimResponse.getExp();
  }

  private String getUsernameFromToken() {
    return this.claimResponse.getUsername();
  }

  private String getClientIdFromToken() {
    return this.claimResponse.getClientId();
  }

  private String getTokenUseFromToken() {
    return this.claimResponse.getTokenUse();
  }

  private Boolean isTokenExpired() {
    // TODO check with current time
    return true;
  }

}
