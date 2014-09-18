package net.club.service;

import java.util.List;

import net.club.dao.AbstractDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractServiceImpl<T> implements AbstractService<T>{

	@Autowired
    public AbstractDAO<T> adao;

    public T save(T entity) {
        return adao.save(entity);
    }

    public void persist(T entity) {
        adao.persist(entity);
    }

    public T get(long id) {
        return adao.get(id);
    }

    public void delete(T entity) {
        adao.delete(entity);
    }

    public void delete(long id) {
        adao.delete(id);
    }

    public List<T> getList(boolean isDesc) {
        return adao.getList(isDesc);
    }

}
