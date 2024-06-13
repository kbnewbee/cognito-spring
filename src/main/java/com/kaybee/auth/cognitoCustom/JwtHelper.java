package com.kaybee.auth.cognitoCustom;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

  private final String issuer = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Bftm8ki6c";
  private Map<String, Object> claimResponse;

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
  private Map<String, Object> getAllClaimsFromToken(String token) {
    JwtDecoder jwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);
    Jwt jwt = jwtDecoder.decode(token);
    Map<String, Object> claims = jwt.getClaims();

    System.out.println(claims);

    return claims;
  }

  private String getExpirationFromToken() {
    return this.claimResponse.get("exp").toString();
  }

  private String getUsernameFromToken() {
    return this.claimResponse.get("username").toString();
  }

  private String getClientIdFromToken() {
    return (String) this.claimResponse.get("client_id");
  }

  private String getTokenUseFromToken() {
    return (String) this.claimResponse.get("token_use");
  }

  private Boolean isTokenExpired() {
    // TODO check with current time
    String string = getExpirationFromToken();
    System.out.println(string);
    ZonedDateTime expiryDateTime = ZonedDateTime.parse(string, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
    boolean before = expiryDateTime.isBefore(currentDateTime);
    System.out.println(before);

    return false;
  }

}
