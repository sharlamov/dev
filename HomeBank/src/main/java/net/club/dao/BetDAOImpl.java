package net.club.dao;

import java.util.Date;
import java.util.List;

import net.club.enums.Equipment;
import net.club.model.Bet;
import net.club.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class BetDAOImpl extends AbstractDAOImpl<Bet> implements BetDAO {

	@SuppressWarnings("unchecked")
	public List<Object[]> getBetsByUserDate(Long userId, Date date) {
	    Session session = sessionFactory.getCurrentSession();
	    String hql = "SELECT b.date,b.user,b.equipment,b.inSuma,b.outSuma,b.text FROM Bet b WHERE b.date = :pdate and b.user.id = :userId";
	    Query query = (Query) session.createQuery(hql);
	    query.setParameter("userId", userId);
	    query.setParameter("pdate", date);
	    List<Object[]> lst = query.list();
	    return lst;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getIncomeGroupByDevices(Date incomeDate1,
			Date incomeDate2, User incomeFilterUser,
			Equipment incomeFilterEquipment) {
	    Session session = sessionFactory.getCurrentSession();
	    
	    String hql = "SELECT equipment, sum(inSuma), sum(outSuma), sum(inSuma) - sum(outSuma) "
	    			+ "FROM Bet WHERE date between :d1 AND :d2 ";

	    if(incomeFilterUser != null && incomeFilterUser.getId() != 0)
			hql += " AND user.id = " + incomeFilterUser.getId();
		
	    if(incomeFilterEquipment != null)
			hql += " AND equipment = " + incomeFilterEquipment.ordinal();
		
	    hql += " GROUP BY equipment";
		
	    Query query = (Query) session.createQuery(hql);
	    query.setParameter("d1", incomeDate1);
	    query.setParameter("d2", incomeDate2);
	    
	    List<Object[]> lst = query.list();
	    return lst;

	}

	public void deleteAllByUser(User user) {
	    Session session = sessionFactory.getCurrentSession();
	    String hql = "DELETE FROM Bet b WHERE b.user = :puser";
	    Query query = (Query) session.createQuery(hql);
	    query.setParameter("puser", user);
	    query.executeUpdate();
	}

}
