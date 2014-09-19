package net.club.dao;

import net.club.model.Movement;


public interface MovementDAO extends AbstractDAO<Movement> {

	public Movement getMovement(Long id);
	
}
