package net.club.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.club.enums.Equipment;
import net.club.enums.RoleType;
import net.club.model.User;
import net.club.service.BetService;
import net.club.service.UserService;

@ManagedBean(name = "reportController")
@ViewScoped
public class ReportController extends AbstractController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268890030211298444L;

	@ManagedProperty(value = "#{betServiceImpl}")
	private transient BetService betService;

	@ManagedProperty(value = "#{userServiceImpl}")
	private transient UserService userService;
	
	private List<SelectItem> equipments;
	
	private List<RoleType> roleTypes;
	
	private List<User> userList;
	
//	reports
	private Date incomeDate1 = new Date();
	
	private Date incomeDate2 = new Date();
	
	private User filterUser = new User();
	
	private Equipment filterEquip;
	
	private List<Object[]> incomeReport = new ArrayList<Object[]>();
	
//	reports
	
	public void init() {
		equipments = loadEquipment();
		roleTypes = loadRoleTypes();
		userList = userService.getList(false);
	}

	public void getIncomeReportList(){
		setIncomeReport(betService.getIncomeGroupByDevices(trunc(incomeDate1), trunc(incomeDate2), filterUser, filterEquip));
	}
	
	private List<SelectItem> loadEquipment() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Equipment eq : Equipment.values()) {
			list.add(new SelectItem(eq, eq.toString()));
		}
		return list;
	}

	private List<RoleType> loadRoleTypes(){
		List<RoleType> list = new ArrayList<RoleType>();
		for(RoleType rt: RoleType.values()){
			list.add(rt);
		}
		return list;
	}
	
	public void setBetService(BetService betService) {
		this.betService = betService;
	}

	public List<SelectItem> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<SelectItem> equipments) {
		this.equipments = equipments;
	}

	public List<RoleType> getRoleTypes() {
		return roleTypes;
	}

	public void setRoleTypes(List<RoleType> roleTypes) {
		this.roleTypes = roleTypes;
	}

	public Date getIncomeDate1() {
		return incomeDate1;
	}

	public void setIncomeDate1(Date incomeDate1) {
		this.incomeDate1 = incomeDate1;
	}

	public Date getIncomeDate2() {
		return incomeDate2;
	}

	public void setIncomeDate2(Date incomeDate2) {
		this.incomeDate2 = incomeDate2;
	}

	public List<Object[]> getIncomeReport() {
		return incomeReport;
	}

	public void setIncomeReport(List<Object[]> incomeReport) {
		this.incomeReport = incomeReport;
	}

	public User getFilterUser() {
		return filterUser;
	}

	public void setFilterUser(User filterUser) {
		this.filterUser = filterUser;
	}

	public Equipment getFilterEquip() {
		return filterEquip;
	}

	public void setFilterEquip(Equipment filterEquip) {
		this.filterEquip = filterEquip;
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
	
}
