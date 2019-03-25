package com.exame.marilia.dao;


import com.exame.marilia.dto.StatDTO;
import com.exame.marilia.model.Simian;

public interface ISimianDAO {

	/**
	 * @param entity
	 */
	void save(Simian entity);

	StatDTO countResults();

	boolean hasDNA(Simian entity);
}