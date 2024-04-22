package com.me.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;

import java.beans.Customizer;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	
	@Bean
    public ReactiveJwtDecoder reactiveJwtDecoder() {
        return ReactiveJwtDecoders.fromIssuerLocation("https://dev-75017519.okta.com/oauth2/default");
    }
	
	 @Bean
	    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
	        http
	            .authorizeExchange()
	                .anyExchange().authenticated()
	                .and()
	            .oauth2ResourceServer()
	                .jwt()
	                    .jwtDecoder(reactiveJwtDecoder());
	        return http.build();
	    }
}
