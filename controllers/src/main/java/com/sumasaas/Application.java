package com.sumasaas;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@SpringBootApplication()
@EnableFeignClients()
@EnableReactiveMongoRepositories()
@EnableMongoAuditing()
@Configuration()
@Slf4j
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}

	@PostConstruct
    public void logTest(){
        MDC.put("name", "data in ");
        MDC.put("lastname", "mdc");
        MDC.put("type", "ID MDC");
        log.error("ERROR test");
        log.info("INFOO test");
        log.warn("WARNN test");
        MDC.clear();
    }
}
