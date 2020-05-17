package com.nineleaps.notification.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nineleaps.notification.model.User;

@Service
public class Consumer {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(User user) {

		System.out.println("Consumed Message --->" + user);
		this.sendMail(user);
	}
	
	private void sendMail(User user) {
		List<User> users = userService.findAll()
				.stream()
				.filter(i -> i.getIsAdmin()!=null && i.getIsAdmin())
				.collect(Collectors.toList());
		System.out.println(users);
		
		for(User u : users) {
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(u.getEmail()); 
	        message.setSubject(user.getName()+" User Created"); 
	        message.setText(user.getName()+" Has Joined the organization"
	        		+ "Please help him with onboard kit.");
	        javaMailSender.send(message);
		}
		
		
	}
}
