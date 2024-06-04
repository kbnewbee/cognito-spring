//package com.kaybee.auth.security.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.Date;
//import java.util.HashMap;
//
//import java.util.function.Function;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtHelper {
//
//  public static void main(String[] args) {
////    String url = "https://alpha-trunk.radixhealth.com/dash";
////    url = url.substring(0, url.length() - 5);
////    System.out.println(url);
////    url = url.substring(url.length() - 16);
////    System.out.println(url);
////
//
//
//    String secret2 = "DASHCONFIGURATIONRELATIENTCONFIGURATORSERVICEAUTHENTICATION";
////    LocalDate now = LocalDate.now();
////    System.out.println(now);
////    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
////    String formattedDateTime = now.format(formatter);
////    System.out.println(formattedDateTime);
////    secret2 += formattedDateTime;
//
////    ZonedDateTime currentTimeInUTC = ZonedDateTime.now(ZoneId.of("UTC"));
////    String format = currentTimeInUTC.format(formatter);
////    System.out.println(format);
//
//    // encode
//    HashMap<String, Object> claims = new HashMap<>();
//    claims.put("k1", "v1");
//    String token = Jwts.builder()
//        .setClaims(claims)
//        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).signWith(
//            SignatureAlgorithm.HS256, secret2).compact();
//
//    System.out.println(token);
//
//    // decode
////    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret2),
////        SignatureAlgorithm.HS256.getJcaName());
////    Claims body = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token).getBody();
////    System.out.println(body);
//
//  }
//
//  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//  private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";
//
//  public String getUsernameFromToken(String token) {
//    return getClaimFromToken(token, Claims::getSubject);
//  }
//
//  public Date getExpirationFromToken(String token) {
//    return getClaimFromToken(token, Claims::getExpiration);
//  }
//
//  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsFunction) {
//    final Claims claims = getAllClaimsFromToken(token);
//    return claimsFunction.apply(claims);
//  }
//
//  private Claims getAllClaimsFromToken(String token) {
//    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//  }
//
//  private Boolean isTokenExpired(String token) {
//    final Date expiration = getExpirationFromToken(token);
//    return expiration.before(new Date());
//  }
//
//  public String generateToken(UserDetails userDetails) {
//    HashMap<String, Object> claims = new HashMap<>();
//    return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
//        .setIssuedAt(new Date(System.currentTimeMillis()))
//        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).signWith(
//            SignatureAlgorithm.HS512, secret).compact();
//  }
//
//  public Boolean validateToken(String token, UserDetails userDetails) {
//    final String username = getUsernameFromToken(token);
//    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//  }
//
//}
