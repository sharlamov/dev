package net.club.dao;

import java.util.ArrayList;
import java.util.List;

import net.club.model.Goods;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOImpl extends AbstractDAOImpl<Goods> implements GoodsDAO {

	@SuppressWarnings("unchecked")
	public Goods getGoods(Long id) {
		Session session = sessionFactory.getCurrentSession();
		List<Goods> goodsList = new ArrayList<Goods>();
        Query query = (Query) session.createQuery("FROM Goods gd WHERE gd.id = :idGoods");
        query.setParameter("idGoods", id);
        goodsList = query.list();
        if (!goodsList.isEmpty())
            return goodsList.get(0); 
        else
            return null;    
	}
}
