package com.exame.marilia.ml.dao.impl;

import com.exame.marilia.ml.dao.IStatDAO;
import com.exame.marilia.ml.dto.StatDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.stream.Stream;

@Repository
public class StatDAO implements IStatDAO {

	private final EntityManager entityManager;

	public StatDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public StatDTO countResults(){
		StringBuilder sql	= new StringBuilder(400);
		sql.append(" select ");
		sql.append("    ifnull(sum(case when simian = 1 then 1 else 0 end),0) count_mutant_dna, ");
		sql.append("    ifnull(sum(case when simian = 0 then 1 else 0 end),0) count_human_dna, ");
		sql.append("    case when ifnull(sum(case when simian = 0 then 1 else 0 end), 0) = 0 then 0 else ");
		sql.append("    round(((sum(case when simian = 1 then 1 else 0 end)*100)/sum(case when simian = 0 then 1 else 0 end)),1) end ratio ");
		sql.append(" from dnas ");

		Stream<StatDTO> statStream  = entityManager.createNativeQuery(sql.toString(), "countResultSimian")
				.getResultStream();

		return statStream.findFirst().get();
	}
}
