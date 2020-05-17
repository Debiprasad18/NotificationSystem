package com.nineleaps.notification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.nineleaps.notification.dao.UserDAO;
import com.nineleaps.notification.model.User;

@Service
public class UserService {

	private final UserDAO dao;

	@Autowired
	private Producer producer;

	@Autowired
	public UserService(UserDAO dao) {
		this.dao = dao;
	}

	public User save(User user) {
		user.setId(UUIDs.timeBased());
		User newUser = dao.save(user);
		producer.sendMessage(user);
		return newUser;
	}

	public List<User> findAll() {
		return (List<User>) dao.findAll();
	}
	
	/*
	 * public List<User> findAllAdmin() { return (List<User>)
	 * dao.findByIsAdminTrue(); }
	 */

	public User update(User user) {
		return dao.updateUser(user.getId(), user.getIsAdmin());
	}
}
