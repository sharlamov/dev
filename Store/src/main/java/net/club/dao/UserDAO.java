package net.club.dao;

import net.club.model.User;


public interface UserDAO extends AbstractDAO<User> {

	public User getUser(String login);
	
}
