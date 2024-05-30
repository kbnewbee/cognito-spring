package com.kaybee.auth.security;

import com.kaybee.auth.security.jwt.JwtAuthenticationEntryPoint;
import com.kaybee.auth.security.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(csrf -> csrf.disable())
        .cors(cors -> cors.disable())
        .authorizeRequests(
            auth -> auth.antMatchers("/ins").authenticated().anyRequest().permitAll())
        .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
        .sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    httpSecurity.addFilterBefore(jwtAuthenticationFilter,
        UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
  }

}
