package net.club.dao;

import java.util.ArrayList;
import java.util.List;

import net.club.model.Movement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MovementDAOImpl extends AbstractDAOImpl<Movement> implements MovementDAO {

	@SuppressWarnings("unchecked")
	public Movement getMovement(Long id) {
		Session session = sessionFactory.getCurrentSession();
		List<Movement> movementList = new ArrayList<Movement>();
        Query query = (Query) session.createQuery("FROM Movement m WHERE m.id = :id_movement");
        query.setParameter("id_movement", id);
        movementList = query.list();
        if (!movementList.isEmpty())
            return movementList.get(0);
        else
            return null;    
	}
}
