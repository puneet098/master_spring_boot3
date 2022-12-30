package com.demo.zookeeper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.zookeeper.client.HelloWorldClient;

@RestController
public class GreetingController {
	
	@Autowired
	private HelloWorldClient helloWorldClient;
	
	@GetMapping("/get-greeting")
	public String greeting() {
		return helloWorldClient.HelloWorld();
	}
	
}
