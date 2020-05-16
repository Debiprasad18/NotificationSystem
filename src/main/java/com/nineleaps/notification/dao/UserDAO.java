package com.nineleaps.notification.dao;

import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nineleaps.notification.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, UUID> {

	@Query("UPDATE user SET isAdmin =:isAdmin WHERE id =:id")
	User updateUser(@Param("id") UUID id, @Param("isAdmin") Boolean isAdmin);

	/*
	 * @Query("Select * from user WHERE isAdmin =True") List<User>
	 * findByIsAdminTrue();
	 */
}
