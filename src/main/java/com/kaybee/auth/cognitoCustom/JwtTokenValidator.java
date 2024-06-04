//package com.kaybee.auth.cognitoCustom;
//
//import com.auth0.jwk.Jwk;
//import com.auth0.jwk.JwkProvider;
//import com.auth0.jwk.JwkProviderBuilder;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.JWTVerifier;
//import java.io.IOException;
//import java.security.interfaces.RSAPublicKey;
//import java.util.concurrent.TimeUnit;
//import org.springframework.stereotype.Component;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//
//public class JwtTokenValidator {
//
//  private final JwkProvider jwkProvider;
//  private final String issuer;
//
//  public JwtTokenValidator() {
//    String jwksUrl = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Bftm8ki6c/.well-known/jwks.json";
//    this.jwkProvider = new JwkProviderBuilder(jwksUrl)
//        .cached(10, 24, TimeUnit.HOURS) // Adjust caching as needed
//        .build();
//    this.issuer = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Bftm8ki6c";
//  }
//
//  public DecodedJWT validateToken(String token) throws IOException, JWTVerificationException {
//    DecodedJWT decodedJWT = JWT.decode(token);
//    RSAPublicKey publicKey = getPublicKey(decodedJWT.getKeyId());
//    Algorithm algorithm = Algorithm.RSA256(publicKey, null);
//
//    JWTVerifier verifier = JWT.require(algorithm)
//        .withIssuer(issuer)
//        .build();
//
//    return verifier.verify(token);
//  }
//  private RSAPublicKey getPublicKey(String kid) throws IOException {
//    try {
//      Jwk jwk = jwkProvider.get(kid);
//      return (RSAPublicKey) jwk.getPublicKey();
//    } catch (Exception e) {
//      throw new IOException("Failed to get JWK for kid: " + kid, e);
//    }
//  }
//
//}
