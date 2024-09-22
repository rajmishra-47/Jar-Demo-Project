package com.Jar_Demo_Project.Jar_Demo_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;



@SpringBootApplication
public class JarDemoProjectApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JarDemoProjectApplication.class, args);
	}

	@Bean
	public KeyResolver keyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}

}
