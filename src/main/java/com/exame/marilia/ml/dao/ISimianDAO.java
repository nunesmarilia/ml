package com.exame.marilia.ml.dao;

import com.exame.marilia.ml.model.Simian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository	
public interface ISimianDAO extends CrudRepository<Simian, String> {
}