package net.club.service;

import net.club.model.User;

public interface UserService extends AbstractService<User> {

	public User getUser(String login); 

}
