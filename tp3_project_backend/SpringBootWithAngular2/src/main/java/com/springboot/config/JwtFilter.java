package com.springboot.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        final String authHeader = httpServletRequest.getHeader("authorization");

        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (authHeader == null || authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invlid Authorization header");
            }
            final String TOKEN = authHeader.substring(7);

            try {
                final Claims CLAIMS = Jwts.parser().setSigningKey("secretkey").parseClaimsJwt(TOKEN).getBody();
                httpServletRequest.setAttribute("claims", CLAIMS);
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }
        }
    }
}

