//package com.kaybee.auth.security.jwt;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//  @Autowired
//  private JwtHelper jwtHelper;
//  @Autowired
//  private UserDetailsService userDetailsService;
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//      FilterChain filterChain) throws ServletException, IOException {
//
//    String requestHeader = request.getHeader("Authorization");
//    String token = null;
//    String usernameFromToken = null;
//
//    if (requestHeader != null && requestHeader.startsWith("Bearer")) {
//      token = requestHeader.substring(7);
//      usernameFromToken = this.jwtHelper.getUsernameFromToken(token);
//    }
//
//    if (usernameFromToken != null
//        && SecurityContextHolder.getContext().getAuthentication() == null) {
//      UserDetails userDetails = this.userDetailsService.loadUserByUsername(usernameFromToken);
//      Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
//      if (validateToken) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//            userDetails, null, userDetails.getAuthorities());
//        usernamePasswordAuthenticationToken.setDetails(
//            new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//      }
//    }
//
//    filterChain.doFilter(request, response);
//  }
//}
