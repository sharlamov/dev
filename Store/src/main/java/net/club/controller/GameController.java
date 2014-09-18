package net.club.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.club.enums.Equipment;
import net.club.model.Bet;
import net.club.service.BetService;

@ManagedBean(name = "gameController")
@ViewScoped
public class GameController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -5323795337687170091L;

	@ManagedProperty(value = "#{betServiceImpl}")
	private transient BetService betService;

	private List<SelectItem> equipments;
	
	private Bet currentBet;
	
	private List<Object[]> bets;
	
	public void init() {
		currentBet = getInitBet();
		bets = betService.getBetsByUserDate(getLoggedUser().getId(), getCdate());
		equipments = loadEquipment();
	}

	public Bet getInitBet(){
		Bet b = new Bet();
		b.setDate(getCdate());
		b.setUser(getLoggedUser());
		return b;
	}

	private List<SelectItem> loadEquipment() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Equipment eq : Equipment.values()) {
			list.add(new SelectItem(eq, eq.toString()));
		}
		return list;
	}

	public void saveBet() {
		betService.save(currentBet);
		currentBet = null;
	}

	public void setBetService(BetService betService) {
		this.betService = betService;
	}

	public Bet getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(Bet currentBet) {
		this.currentBet = currentBet;
	}

	public List<SelectItem> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<SelectItem> equipments) {
		this.equipments = equipments;
	}

	public List<Object[]> getBets() {
		return bets;
	}

	public void setBets(List<Object[]> bets) {
		this.bets = bets;
	}

}
