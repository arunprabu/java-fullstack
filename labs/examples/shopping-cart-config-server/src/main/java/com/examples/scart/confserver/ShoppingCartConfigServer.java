package com.examples.scart.confserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ShoppingCartConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartConfigServer.class, args);
	}

}
