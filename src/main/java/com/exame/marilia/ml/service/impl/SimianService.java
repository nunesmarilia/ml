package com.exame.marilia.ml.service.impl;

import javax.annotation.Resource;

import com.exame.marilia.ml.dao.SimianDAO;
import com.exame.marilia.ml.model.Simian;
import com.exame.marilia.ml.service.ISimianService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author marilia.alves
 *
 */

@Service
public class SimianService implements ISimianService {

	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	
	private static final long serialVersionUID = -7676073575849665613L;
	
	@Resource
	SimianDAO dao;
	
	/**************************************************************/
	/****************** PERSISTÊNCIA DE DADOS *********************/
	/**************************************************************/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Simian entity) throws Exception{
		try {
		//	if( !this.validateSimian(entity) ) {
				dao.save(entity);
		//	}

		}catch (Exception e) {
			throw e;
		}
	}

	/**************************************************************/
	/************************ CONSULTAS ***************************/
	/**************************************************************/

	/*
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public StatDTO countResults() throws Exception{
		try {
			return dao.countResults();

		} catch (Exception e) {
			throw e;
		}
	}
*/
	/**************************************************************/
	/************************ VALIDAÇÕES **************************/
	/**************************************************************/

/*
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	boolean validateSimian(Simian entity){
		return dao.hasDNA(entity);
	}
	*/
}