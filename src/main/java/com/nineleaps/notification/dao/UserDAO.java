package com.nineleaps.notification.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.nineleaps.notification.model.User;

public interface UserDAO extends CrudRepository<User, UUID> {

}
