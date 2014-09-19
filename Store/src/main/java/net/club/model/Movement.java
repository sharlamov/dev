package net.club.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "db_movements")
public class Movement extends AbstractModel {


	private static final long serialVersionUID = 1L;

	@Column
	Date date;
	
	@Column
	User user;
	
	@Column
	Store storeOut;
	
	@Column
	Store storeIn;

	@Column
	Goods good;

	@Column
	Double count;

	@Column
	Double suma;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStoreOut() {
		return storeOut;
	}

	public void setStoreOut(Store storeOut) {
		this.storeOut = storeOut;
	}

	public Store getStoreIn() {
		return storeIn;
	}

	public void setStoreIn(Store storeIn) {
		this.storeIn = storeIn;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

}