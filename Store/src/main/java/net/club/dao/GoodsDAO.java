package net.club.dao;

import net.club.model.Goods;


public interface GoodsDAO extends AbstractDAO<Goods> {

	public Goods getGoods(Long id);
	
}
