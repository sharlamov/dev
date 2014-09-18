package net.club.dao;

import java.util.ArrayList;
import java.util.List;

import net.club.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		Session session = sessionFactory.getCurrentSession();
		List<User> userList = new ArrayList<User>();
        Query query = (Query) session.createQuery("FROM User u WHERE u.username = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (!userList.isEmpty())
            return userList.get(0);
        else
            return null;    
	}


}
