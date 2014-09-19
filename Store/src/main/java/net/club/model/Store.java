package net.club.model;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "db_store")
public class Store extends AbstractModel  {

	private static final long serialVersionUID = -1500937973766127288L;

 	@Column
	String storeName;

	@Column
	String adress;
 

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAdress() {
		return adress;
	}

	public void setStoreAdress(String storeAdress) {
		this.adress = storeAdress;
	}
  

}