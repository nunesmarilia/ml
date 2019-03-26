package com.exame.marilia.ml.service;

import com.exame.marilia.ml.model.Simian;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
	//public StatDTO countResults() throws Exception;
}