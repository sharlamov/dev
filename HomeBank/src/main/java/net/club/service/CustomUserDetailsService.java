package net.club.service;

import java.util.List;

import net.club.dao.UserDAO;
import net.club.enums.RoleType;
import net.club.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
   
    @Autowired
    private UserDAO userDAO;   

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       
    	User domainUser = null;

        domainUser = userDAO.getUser(login);
        if(domainUser == null){
        	List<User> list = userDAO.getList(false);
        	if(list.isEmpty()){
        		domainUser = new User();
        		domainUser.setId(0);
        		domainUser.setUsername("empty");
        		domainUser.setPassword("1");
        		domainUser.setRole(RoleType.ROLE_ADMIN);
        	}else{
        		return null;
        	}
        }
    	
    	
        return domainUser;
    }
   

}   
