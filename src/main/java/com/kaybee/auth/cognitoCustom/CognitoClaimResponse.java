package com.kaybee.auth.cognitoCustom;

import java.time.Instant;
import lombok.Data;

@Data
public class CognitoClaimResponse {
  private String origin_jti;
  private String sub;
  private String event_id;
  private String tokenUse;
  private String scope;
  private Long auth_time; // Long
  private String iss;
  private Instant exp; // Instant
  private Instant iat; // Instant
  private String clientId;
  private String jti;
  private String username;

}
