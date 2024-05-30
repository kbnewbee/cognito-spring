package com.kaybee.auth.security.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  /**
   *  method is called whenever as exception is thrown due to
   *  unauthenticated user trying to access the resource that
   *  required authentication
   *
   * @param request
   * @param response
   * @param authException
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authException) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    writer.println("access denied :: " + authException.getMessage());
  }
}
