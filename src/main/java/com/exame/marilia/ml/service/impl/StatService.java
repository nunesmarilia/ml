package com.exame.marilia.ml.service.impl;

import com.exame.marilia.ml.dao.IStatDAO;
import com.exame.marilia.ml.dto.StatDTO;
import com.exame.marilia.ml.service.IStatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author marilia.alves
 *
 */

@Service
public class StatService implements IStatService {

	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	private final IStatDAO dao;

	/**
	 * @param dao
	 */
	public StatService(IStatDAO dao){
		this.dao  = dao;
	}

	/**************************************************************/
	/************************ CONSULTAS ***************************/
	/**************************************************************/

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public StatDTO countResults() throws Exception{
		return dao.countResults();
	}
}