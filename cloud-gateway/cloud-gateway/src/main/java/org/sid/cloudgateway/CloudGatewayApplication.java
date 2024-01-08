package org.sid.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudGatewayApplication {
    @Bean
	RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r->r.path("/cours/**").uri("http//localhost:8081").id("r1"))
				.route(r->r.path("/students/**").uri("http//localhost:8081").id("r2"))
				.build();

	}
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}
