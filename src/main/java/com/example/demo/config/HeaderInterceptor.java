package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.equals("DWAi9c!j#8*iRD*Q64kqH150"))
            return true;
        else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
    }

}
