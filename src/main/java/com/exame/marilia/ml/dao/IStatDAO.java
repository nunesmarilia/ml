package com.exame.marilia.ml.dao;

import com.exame.marilia.ml.dto.StatDTO;
import org.springframework.stereotype.Repository;

@Repository	
public interface IStatDAO {

	StatDTO countResults();
}