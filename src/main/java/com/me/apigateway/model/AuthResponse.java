package com.me.apigateway.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.core.OAuth2AccessToken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

	private String userId;
	private String accessToken;
	private String refreshToken;
	private long login_expireAt;
	private Collection<String> authorities;
	
}
