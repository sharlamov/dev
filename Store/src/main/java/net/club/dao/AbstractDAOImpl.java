package net.club.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

public class AbstractDAOImpl<T> implements AbstractDAO<T> {

    private Class<T> clazz = null;

    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAOImpl() {
        this.clazz =  (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractDAO.class);
    }

    @SuppressWarnings("unchecked")
	public T get(long id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public void delete(T entity) {
    	sessionFactory.getCurrentSession().delete(entity);
    }


    @SuppressWarnings("unchecked")
	public void delete(long id) {
    	Session session = sessionFactory.getCurrentSession();
        T entity = (T) session.get(clazz, id);
        session.delete(entity);
    }

    @SuppressWarnings("unchecked")
	public T save(T entity) {
    	Session session = sessionFactory.getCurrentSession();
    	return (T) session.merge(entity);
    }

    public void persist(T entity) {
    	Session session = sessionFactory.getCurrentSession();
    	session.persist(entity);
    }

    @SuppressWarnings("unchecked")
    public List<T> getList(boolean isDesc) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("from " + clazz.getName() + " order by id " + ( isDesc ? " desc " : " asc " ));
        List<T> lst = query.list();
        return lst != null ? lst : new ArrayList<T>();
    }

}
