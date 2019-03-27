package com.exame.marilia.ml.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dnas")
@SqlResultSetMapping(name="countResultSimian", classes={@ConstructorResult(targetClass=com.exame.marilia.ml.dto.StatDTO.class, columns={
		@ColumnResult(name="count_mutant_dna", type= BigDecimal.class),
		@ColumnResult(name="count_human_dna", type= BigDecimal.class),
		@ColumnResult(name="ratio", type= BigDecimal.class)
})})
public class Simian {

	@Id
	@Column(name="id")
	private String id;

	@Transient
	private List<String> dna;

	@Column(name="simian")
	private boolean simian;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}

	public boolean isSimian() {
		return simian;
	}

	public void setSimian(boolean simian) {
		this.simian = simian;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Simian)) return false;
		Simian simian = (Simian) o;
		return Objects.equals(id, simian.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}