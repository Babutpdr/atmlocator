package com.mobiquity.atmlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class AtmLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmLocatorApplication.class, args);
	}
	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("atmlocator");
    }
}
