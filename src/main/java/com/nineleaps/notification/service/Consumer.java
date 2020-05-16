package com.nineleaps.notification.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nineleaps.notification.model.User;

@Service
public class Consumer {

	@Autowired
	private UserService userService;

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) {
		List<User> users = userService.findAll()
				.stream()
				.filter(i -> i.getIsAdmin()!=null && i.getIsAdmin())
				.collect(Collectors.toList());
		System.out.println(users);
		System.out.println("Consumed Message --->" + message);
	}
}
