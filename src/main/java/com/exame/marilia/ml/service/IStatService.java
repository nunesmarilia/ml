package com.exame.marilia.ml.service;

import com.exame.marilia.ml.dto.StatDTO;
import com.exame.marilia.ml.model.Simian;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface IStatService {

	StatDTO countResults() throws Exception;
}