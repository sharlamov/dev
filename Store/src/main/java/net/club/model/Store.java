package net.club.model;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "db_store")
public class Store extends AbstractModel  {

	private static final long serialVersionUID = -1500937973766127288L;

 	@Column
	String name;

	@Column
	String adress;
 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
  

}