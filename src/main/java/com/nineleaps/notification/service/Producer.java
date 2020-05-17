package com.nineleaps.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nineleaps.notification.model.User;

@Service
public class Producer {
	private static final String TOPIC = "users";
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Async
	public void sendMessage(User user) {
		System.out.println("Producing message --> " + user);
		this.kafkaTemplate.send(TOPIC, user);
	}
}
