package com.nineleaps.notification.service;

import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) {
		System.out.println(String.format("$$ -> Consumed Message -> %s", message));
	}
}
