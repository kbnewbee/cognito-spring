//package com.kaybee.auth.cognitoSimple;
//
//import com.nimbusds.jose.jwk.JWK;
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
//import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//    http
//        .authorizeHttpRequests(
//            auth -> auth.antMatchers("/ins").authenticated().anyRequest().permitAll())
//        .httpBasic(Customizer.withDefaults())
//        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//        .sessionManagement(
//            (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .exceptionHandling((exceptions) -> exceptions
//            .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//            .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
//        );
//
//    return http.build();
//  }
//
//  @Bean
//  public JwtDecoder jwtDecoder() {
//    String issuerUri = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_Bftm8ki6c";
//    return JwtDecoders.fromIssuerLocation(issuerUri);
//  }
//
//}
