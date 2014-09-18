package net.club.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.club.enums.Equipment;

@Entity
@Table(name="db_bet")
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.NONE)
public class Bet extends AbstractModel {

	private static final long serialVersionUID = 4350608066758861272L;

	@Column	
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column
    @XmlElement(name = "equipment")
    private Equipment equipment;
    
    @Column
    @XmlElement(name = "inSuma")
    private Double inSuma;
    
    @Column
    @XmlElement(name = "outSuma")
    private Double outSuma;

    @Column
    @XmlElement(name = "text")
    private String text;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Double getInSuma() {
		return inSuma;
	}

	public void setInSuma(Double inSuma) {
		this.inSuma = inSuma;
	}

	public Double getOutSuma() {
		return outSuma;
	}

	public void setOutSuma(Double outSuma) {
		this.outSuma = outSuma;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}

