package net.club.dao;

import net.club.model.Store;


public interface StoreDAO extends AbstractDAO<Store> {

	public Store getStore(Long idStore);
	
}
