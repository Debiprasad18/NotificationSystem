package com.nineleaps.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message --->"+ message);
	}
}
