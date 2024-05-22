package com.microservicios.booking_service.config;

import com.microservicios.booking_service.utils.AuthService;
import feign.Feign;
import feign.RequestInterceptor;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = "";
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
    @Bean
    public Feign.Builder feignBuilder(MeterRegistry meterRegistry){
        return Feign.builder().addCapability(new MicrometerCapability(meterRegistry));
    }
}
