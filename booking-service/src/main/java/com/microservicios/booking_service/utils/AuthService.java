package com.microservicios.booking_service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private OAuth2AuthorizedClientManager authorizedClientManager;
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    public String getToken(){
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("keyclock")
                .principal("client")
                .build();
        OAuth2AccessToken accessToken = authorizedClientManager.authorize(authorizeRequest).getAccessToken();
        return accessToken.getTokenValue();
    }
}
