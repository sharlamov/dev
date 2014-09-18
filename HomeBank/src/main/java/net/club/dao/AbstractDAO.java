package net.club.dao;

import java.util.List;

public interface AbstractDAO<T> {

    public T save(T entity);

    public void persist(T entity);

    public T get(long id);

    public void delete(T entity);

    public void delete(long id);

    public List<T> getList(boolean isDesc);
}
