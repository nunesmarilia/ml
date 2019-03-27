package com.exame.marilia.ml.service.impl;

import com.exame.marilia.ml.dao.IStatDAO;
import com.exame.marilia.ml.dto.StatDTO;
import com.exame.marilia.ml.service.IStatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author marilia.alves
 *
 */

@Service
public class StatService implements IStatService {

	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	
	private static final long serialVersionUID = -7676073575849665613L;

	private final IStatDAO dao;

	public StatService(IStatDAO dao){
		this.dao  = dao;
	}

	/**************************************************************/
	/************************ CONSULTAS ***************************/
	/**************************************************************/

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public StatDTO countResults() throws Exception{
		try {
			return dao.countResults();

		} catch (Exception e) {
			throw e;
		}
	}
}