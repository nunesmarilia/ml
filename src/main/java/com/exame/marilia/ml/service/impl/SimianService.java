package com.exame.marilia.ml.service.impl;

import com.exame.marilia.ml.dao.ISimianDAO;
import com.exame.marilia.ml.model.Simian;
import com.exame.marilia.ml.service.ISimianService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author marilia.alves
 *
 */

@Service
@Transactional
public class SimianService implements ISimianService {

	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/

	private final ISimianDAO dao;

	public SimianService(ISimianDAO dao){
		this.dao  = dao;
	}
	
	/**************************************************************/
	/****************** PERSISTENCIA DE DADOS *********************/
	/**************************************************************/
	@Override
	public void save(Simian entity){
		dao.save(entity);
	}
}