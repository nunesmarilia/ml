package com.exame.marilia.dao.impl;

import com.exame.marilia.dao.ISimianDAO;
import com.exame.marilia.dto.StatDTO;
import org.hibernate.Session;
import com.exame.marilia.model.Simian;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository	
public interface SimianDAO implements ISimianDAO {
	
	@Override
	void save(Simian entity){
		this.entityManager.persist(entity);
	}

	@Override
	StatDTO countResults(){
		Session session = (Session)entityManager.getDelegate();

		StringBuilder sql	= new StringBuilder(400);
		sql.append(" select ");
		sql.append("    isnull(sum(case when simian = 1 then 1 else 0 end),0) count_mutant_dna, ");
		sql.append("    isnull(sum(case when simian = 0 then 1 else 0 end),0) count_human_dna, ");
		sql.append("    case when isnull(sum(case when simian = 0 then 1 else 0 end), 0) = 0 then 0 else ");
		sql.append("    round(((sum(case when simian = 1 then 1 else 0 end)*100)/sum(case when simian = 0 then 1 else 0 end)),2) end ratio((sum(case when simian = 1 then 1 else 0 end)*100)/sum(case when simian = 0 then 1 else 0 end)) ratio ");
		sql.append(" from dnas ");

		org.hibernate.Query  query = (org.hibernate.Query)session.createSQLQuery(sql.toString()).setResultTransformer(Transformers.aliasToBean(StatDTO.class));

		return (StatDTO)query.getSingleResult();
	}

	@Override
	boolean hasDuplicatedLogin(Simian entity){
		org.hibernate.Query  query = (org.hibernate.Query)session.createSQLQuery("select ").setResultTransformer(Transformers.aliasToBean(StatDTO.class));
		query.setParameter("user", entity.getLogin() == null ? null :  entity.getLogin());
		query.setParameter("id", entity.getId());

		return query.getResultList().size()>0;
	}
}