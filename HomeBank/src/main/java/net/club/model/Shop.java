package net.club.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.NONE)
public class Shop {
	
	@XmlElement(name = "name")
	String name;
	
	@XmlElementWrapper(name = "staff")
    @XmlElement(name = "sname")
	String staffName[];
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName[]) {
		this.staffName = staffName;
	}
 
	//getter and setter methods
 
}
