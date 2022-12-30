package com.demo.kafka.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.service.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final Producer producer;

	@Autowired
	KafkaController(Producer producer) {
	    this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
	    this.producer.sendMessage(message);
	}
}
