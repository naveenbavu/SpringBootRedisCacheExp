package com.redisexample.redisexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableCaching
@Slf4j
@EnableReactiveMongoRepositories(basePackages = "com.redisexample.redisexample.repository")
@EnableAutoConfiguration
public class RedisexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisexampleApplication.class, args);
	}

}
