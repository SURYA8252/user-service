package com.lcwd.user.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
//	@Bean
//	@LoadBalanced
//    public RestTemplate restTemplate() {
//    	RestTemplate restTemplate = new RestTemplate();
//    	List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//    	interceptors.add(new RestTemplateInceptor(manager()));
//    	restTemplate.setInterceptors(interceptors);
//    	return restTemplate;
//    }
	  @Bean
	  @LoadBalanced
	  public RestTemplate restTemplate() {
		  return new RestTemplate();
	  }
}
