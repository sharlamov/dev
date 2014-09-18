package net.club.service;

import java.util.Date;
import java.util.List;

import net.club.enums.Equipment;
import net.club.model.Bet;
import net.club.model.User;

public interface BetService extends AbstractService<Bet> {

	List<Object[]> getBetsByUserDate(Long userId, Date date);

	void deleteAllByUser(User user);
	
	List<Object[]> getIncomeGroupByDevices(Date incomeDate1, Date incomeDate2, User incomeFilterUser, Equipment incomeFilterEquipment);

}
