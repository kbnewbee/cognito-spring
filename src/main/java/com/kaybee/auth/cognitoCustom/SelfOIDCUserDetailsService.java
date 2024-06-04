//package com.kaybee.auth.cognitoCustom;
//
//import java.util.Collections;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.context.annotation.Configuration;
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
//@Configuration
//public class SelfOIDCUserDetailsService implements OAuth2UserService<OidcUserRequest, OidcUser> {
//
//  private final OidcUserService oidcUserService = new OidcUserService();
//  private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = Collections
//      .singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//  /**
//   * During the authentication process, Spring Security calls the loadUser(OidcUserRequest userRequest).
//   * This method should return a OidcUser object
//   * @param userRequest
//   * @return
//   * @throws OAuth2AuthenticationException
//   */
//  @Override
//  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//    OidcUser oidcUser = oidcUserService.loadUser(userRequest);
//    System.out.println("User from cognito :: " + oidcUser);
//
//    String username = oidcUser.getUserInfo().getClaim("sub");
//    Map<String, Object> oidcUserClaims = new LinkedHashMap<>(oidcUser.getUserInfo().getClaims());
//    oidcUserClaims.put("username", username);
//    return new DefaultOidcUser(DEFAULT_AUTHORITIES, oidcUser.getIdToken(),
//        new OidcUserInfo(oidcUserClaims));
//  }
//}
