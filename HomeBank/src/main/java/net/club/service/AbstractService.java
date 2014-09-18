package net.club.service;

import java.util.List;

public interface AbstractService<T>{

    public T save(T entity);

    public void persist(T entity);

    public T get(long id);

    public void delete(T entity);

    public void delete(long id);

    public List<T> getList(boolean isDesc);
}
