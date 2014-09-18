package net.club.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.club.enums.RoleType;
import net.club.model.User;
import net.club.service.BetService;
import net.club.service.UserService;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "listController")
@ViewScoped
public class ListController extends AbstractController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5561294778969213351L;
	
	@ManagedProperty(value = "#{userServiceImpl}")
	private transient UserService userService;
	
	@ManagedProperty(value = "#{betServiceImpl}")
	private transient BetService betService;

	private User newUser = new User();
	
	private List<RoleType> roleTypes;
	
	private List<User> userList;

	public void init() {
		roleTypes = loadRoleTypes();
		userList = userService.getList(false);
	}
	
	public List<RoleType> loadRoleTypes(){
		List<RoleType> list = new ArrayList<RoleType>();
		for(RoleType rt: RoleType.values()){
			list.add(rt);
		}
		return list;
	}
	
	public void deleteUser(Long id){
		if(id != null){
			User delUser = userService.get(id);
			betService.deleteAllByUser(delUser);
			userService.delete(id);
		}
	}
	
	public void saveNewUser(){
		userService.save(newUser);
	}
	
	public void onRowEdit(RowEditEvent event) {
		User usr = (User) event.getObject();
		userService.save(usr);
    }

	public boolean userValidation(User user){
      FacesMessage msg = new FacesMessage("User Edited error", "asd");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      return true;
	}
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	public List<RoleType> getRoleTypes() {
		return roleTypes;
	}

	public void setRoleTypes(List<RoleType> roleTypes) {
		this.roleTypes = roleTypes;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBetService(BetService betService) {
		this.betService = betService;
	}
}
