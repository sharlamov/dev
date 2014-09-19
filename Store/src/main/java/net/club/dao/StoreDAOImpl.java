package net.club.dao;

import java.util.ArrayList;
import java.util.List;

import net.club.model.Store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAOImpl extends AbstractDAOImpl<Store> implements StoreDAO {

	@SuppressWarnings("unchecked")
	public Store getStore(Long idStore) {
		Session session = sessionFactory.getCurrentSession();
		List<Store> storeList = new ArrayList<Store>();
        Query query = (Query) session.createQuery("FROM Store st WHERE st.id = :id_store");
        query.setParameter("id_store", idStore);
        storeList = query.list();
        if (!storeList.isEmpty())
            return storeList.get(0);
        else
            return null;    
	}
}
