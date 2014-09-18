package net.club.service;

import java.util.Date;
import java.util.List;

import net.club.dao.BetDAO;
import net.club.enums.Equipment;
import net.club.model.Bet;
import net.club.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BetServiceImpl  extends AbstractServiceImpl<Bet>  implements BetService{
	
	@Autowired
	BetDAO betDAO;
	
	public List<Object[]> getBetsByUserDate(Long userId, Date date){
		return betDAO.getBetsByUserDate(userId,date);
	}
	
	public void deleteAllByUser(User user){
		betDAO.deleteAllByUser(user);
	}
	
	public List<Object[]> getIncomeGroupByDevices(Date incomeDate1,
			Date incomeDate2, User incomeFilterUser,
			Equipment incomeFilterEquipment) {
		return betDAO.getIncomeGroupByDevices(incomeDate1, incomeDate2, incomeFilterUser, incomeFilterEquipment);
	}

}    


