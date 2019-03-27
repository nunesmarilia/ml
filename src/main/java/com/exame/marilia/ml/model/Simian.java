package com.exame.marilia.ml.model;

import javax.persistence.*;
import java.io.Serializable;
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
public class Simian implements Serializable {

	private static final long serialVersionUID = -4042023941980758267L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="dna", unique = true)
	private String keyDna;

	@Transient
	private List<String> dna;

	@Column(name="simian")
	private boolean simian;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyDna() {
		return keyDna;
	}

	public void setKeyDna(String keyDna) {
		this.keyDna = keyDna;
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