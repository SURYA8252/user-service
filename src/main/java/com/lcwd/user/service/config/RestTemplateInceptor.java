//package com.lcwd.user.service.config;
//
//import java.io.IOException;
//
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
//
//public class RestTemplateInceptor implements ClientHttpRequestInterceptor {
//
//	private OAuth2AuthorizedClientManager manager;
//	
//	public RestTemplateInceptor(OAuth2AuthorizedClientManager manager) {
//		super();
//		this.manager = manager;
//	}
//
//
//
//	@Override
//	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//			throws IOException {
//		manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal(null))
//		return null;
//	}
//
//}
