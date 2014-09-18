package net.club.dao;

import java.util.Date;
import java.util.List;

import net.club.enums.Equipment;
import net.club.model.Bet;
import net.club.model.User;


public interface BetDAO extends AbstractDAO<Bet> {

	List<Object[]> getBetsByUserDate(Long userId, Date date);

	List<Object[]> getIncomeGroupByDevices(Date incomeDate1, Date incomeDate2, User incomeFilterUser, Equipment incomeFilterEquipment);

	void deleteAllByUser(User user);
}
