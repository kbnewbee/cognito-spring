package com.kaybee.auth.security.jwt;

import com.nimbusds.jose.util.Base64;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
  private final static String SECRET_SIGNING_KEY = "DASHCONFIGURATIONRELATIENTCONFIGURATORSERVICEAUTHENTICATION";
  public static void main(String[] args) {
//    String token = "eyJhbGciOiJIUzI1NiJ9.eyJQbGF0Zm9ybV9CdXNpbmVzc1VuaXROYW1lIjoiQUxQSEFfVEVOQU5UIiwiUGxhdGZvcm1fRUhSSWQiOm51bGwsIlBsYXRmb3JtX0VIUk5hbWUiOiJBVEhFTkEiLCJhcHBPcmlnaW4iOiJodHRwczovL2FscGhhLXRydW5rLnJhZGl4aGVhbHRoLmNvbSIsIlBsYXRmb3JtX0J1c2luZXNzTmFtZSI6IkFMUEhBX1RFTkFOVCJ9.4Y6JbL9nhTwR0T1b_QdQmWPL_hjJimKQt8-YBPRC8pA";
//    String t= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzb21lIjoicGF5bG9hZCJ9.bMCL9cq17jP-znyjWBAlkmnqb69dAIeixU6pUNApyC0";
//    String g= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.po3DMkZDZTlPs-qCSX3DF5zaPv92srfcNqW3uyD5FXo";



//    byte[] bytes = SECRET_SIGNING_KEY.getBytes();
//    String string = Arrays.toString(bytes);
//    System.out.println(bytes);
//
//    System.out.println(Arrays.toString(bytes));

    HashMap<String, Object> m = new HashMap<>();
    m.put("ka", "asd");


//    String re = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBPcmlnaW4iOiJodHRwczovL2FscGhhLXRydW5rLnJhZGl4aGVhbHRoLmNvbSIsIlBsYXRmb3JtX0J1c2luZXNzTmFtZSI6IkFMUEhBX1RSVU5LIiwiUGxhdGZvcm1fQnVzaW5lc3NVbml0TmFtZSI6IkFMUEhBX1RSVU5LIiwiUGxhdGZvcm1fRUhSSWQiOiI5OTkiLCJQbGF0Zm9ybV9FSFJOYW1lIjoiREFTSCJ9.LeUc3V9Cf2jC0X1_icyXyJ2UkqpSpa7mnDHbELqP-yo";

    // generate token
    String jwtToken = Jwts.builder()
        .setClaims(m)
        .signWith(SignatureAlgorithm.HS256, SECRET_SIGNING_KEY.getBytes()).compact();
    System.out.println(jwtToken);


    String secretForParsing = "REFTSENPTkZJR1VSQVRJT05SRUxBVElFTlRDT05GSUdVUkFUT1JTRVJWSUNFQVVUSEVOVElDQVRJT04=";

    String encode = TextCodec.BASE64.encode(SECRET_SIGNING_KEY);
    System.out.println(encode);
    String tokenFromPython = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.po3DMkZDZTlPs-qCSX3DF5zaPv92srfcNqW3uyD5FXo";

    // parsing the token
    Claims body = Jwts.parser()
        .setSigningKey(TextCodec.BASE64.decode(secretForParsing))
        .parseClaimsJws(tokenFromPython)
        .getBody();
    System.out.println(body);

  }

}
