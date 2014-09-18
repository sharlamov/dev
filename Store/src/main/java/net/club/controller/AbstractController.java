package net.club.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.club.enums.RoleType;
import net.club.model.User;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@ViewScoped
public class AbstractController implements Serializable{

	private static final long serialVersionUID = -8184811714354388568L;
	
	private User loggedUser;
	
	private Date cdate;

	public AbstractController() {
		loggedUser = defineLoggedUser();
		cdate = trunc(new Date());
	}

	public Date trunc(Date date){
		if( date != null ){
			date = DateUtils.truncate(date, Calendar.DATE);
			date = DateUtils.addDays(date, 1);
		}
		return date;
	}

	public boolean isAdminUser(){
		return loggedUser.getRole() == RoleType.ROLE_ADMIN ? true : false;
	}
	
	public User defineLoggedUser(){
		User user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			user = (User) auth.getPrincipal();
		}
		return user;
	}

	public Double getSumByCol(List<Object[]>list, Integer col){
		double d = 0.0;
		if(list != null){
			for(Object[] row: list){
				double var = (Double) row[col];
				d += var;
			}
		}
		return d;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public Date getCdate() {
		return cdate;
	}
}
