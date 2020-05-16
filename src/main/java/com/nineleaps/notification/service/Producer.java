package com.nineleaps.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	private static final String TOPIC = "users";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Async
	public void sendMessage(String message) {
		System.out.println("Producing message --> " + message);
		this.kafkaTemplate.send(TOPIC, message);
	}
}
