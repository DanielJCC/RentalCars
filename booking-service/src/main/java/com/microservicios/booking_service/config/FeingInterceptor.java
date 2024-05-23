package com.microservicios.booking_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class FeingInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.getCredentials() instanceof Jwt){
            Jwt jwt = (Jwt) authentication.getCredentials();
            requestTemplate.header("Authorization","Bearer "+jwt.getTokenValue());
        }
    }
}
