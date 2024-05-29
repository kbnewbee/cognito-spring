//package com.kaybee.auth;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//
//public class CCRegRepo implements ClientRegistrationRepository {
//
//  private static final String CLIENT_NAME = "Test";
//
//  private final Map<String, ClientRegistration> registrations = new HashMap<>();
//
//  public CCRegRepo() {
//    loadRegistrations();
//  }
//
//  public void loadRegistrations() {
//    // Load registrations from XML or any other source
//    ClientRegistration clientRegistration = getClientRegistration();
//    registrations.put(clientRegistration.getRegistrationId(), clientRegistration);
//  }
//
//  private ClientRegistration getClientRegistration() {
//    // This method should parse the XML and return a ClientRegistration object
//    // For demonstration purposes, I'm creating a dummy ClientRegistration
//    //String clientId = environment.getProperty("new.client.id");
//    System.out.println(CLIENT_NAME);
//
//    return ClientRegistration.withRegistrationId("cognito")
//        .clientId("clientId")
//        .clientSecret("clientSecret")
//        .clientName("Relatient Cognito SSO")
//        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//        .scope("openid", "email", "profile")
//        .issuerUri("https://cognito-idp.us-east-1.amazonaws.com/us-east-1_iFGrJnYtE")
//        .authorizationUri("https://relatient-dev.auth.us-east-1.amazoncognito.com/oauth2/authorize")
//        .tokenUri("https://relatient-dev.auth.us-east-1.amazoncognito.com/oauth2/token")
//        .userInfoUri("https://relatient-dev.auth.us-east-1.amazoncognito.com/oauth2/userInfo")
//        .jwkSetUri("https://cognito-idp.us-east-1.amazonaws.com/us-east-1_iFGrJnYtE/.well-known/jwks.json")
//        .build();
//  }
//
//  @Override
//  public ClientRegistration findByRegistrationId(String registrationId) {
//    return registrations.get(registrationId);
//  }
//}
