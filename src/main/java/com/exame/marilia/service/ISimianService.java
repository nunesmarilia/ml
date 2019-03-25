package com.exame.marilia.service;

import com.exame.marilia.dto.StatDTO;
import com.exame.marilia.model.Simian;

public interface ISimianService {
	
	/**
	 * @param entity
	 * @throws Exception
	 */
	public void save(Simian entity) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	public StatDTO countResults() throws Exception;
}