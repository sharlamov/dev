package net.club.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import net.club.model.User;
import net.club.service.UserService;

@ManagedBean(name = "userConverter")
@RequestScoped
public class UserConverter implements Converter {

	@ManagedProperty(value = "#{userServiceImpl}")
	private transient UserService userService;
	
	public User getAsObject(FacesContext context, UIComponent component,
			String value) {
	      
		if (value == null || value.isEmpty()) {
			return null;
		} else {
			Long userId = Long.valueOf(value);
			return userService.get(userId);
		}
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || (String.valueOf(value)).isEmpty()) {
			return "";
		} else {
			return String.valueOf(((User) value).getId());
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
