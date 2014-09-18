package net.club.service;

import net.club.dao.UserDAO;
import net.club.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl  extends AbstractServiceImpl<User>  implements UserService{
	
	@Autowired
	UserDAO userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}
	


}    


