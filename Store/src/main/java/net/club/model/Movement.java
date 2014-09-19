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
	Date dtMovement;
	@Column
	Long idUser;
	
	@Column
	Long idStore;
	
	@Column
	Long idGoods;
	
	@Column
	String Name;

	@Column
	String Code;

	@Column
	double priceIn;

	@Column
	double priceOut;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public double getPriceIn() {
		return priceIn;
	}

	public void setPriceIn(double priceIn) {
		this.priceIn = priceIn;
	}

	public double getPriceOut() {
		return priceOut;
	}

	public void setPriceOut(double priceOut) {
		this.priceOut = priceOut;
	}

	
}