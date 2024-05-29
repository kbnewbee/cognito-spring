//package com.kaybee.auth;
//
//import java.util.Collections;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//
//public class RUserDetailsService implements OAuth2UserService<OidcUserRequest, OidcUser> {
//
//
//  private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = Collections
//      .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//  final OidcUserService delegate = new OidcUserService();
//
//  @Override
//  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//    OidcUser user = delegate.loadUser(userRequest);
//    System.out.println("User from oauth server: " + user);
//    String userName = user.getUserInfo().getClaim("sub");
//
//    System.out.println("store new user in db with username and pwd");
//
//    Map<String, Object> oidcUserClaims = new LinkedHashMap<>(user.getUserInfo().getClaims());
//    oidcUserClaims.put("username", userName);
//    user = new DefaultOidcUser(DEFAULT_AUTHORITIES, user.getIdToken(), new OidcUserInfo(oidcUserClaims));
//    return user;
//
//  }
//}
