package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleRestApiApplication {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/welcome/{name}/{address}")
	public String welcome(@PathVariable String name, @PathVariable String address) {
		return "Welcome "+name + "<br>You are coming from "+address;
	}
		

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApiApplication.class, args);
	}

}
