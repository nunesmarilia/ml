package com.exame.marilia.ml.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dnas")

public class Simian {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@ElementCollection
	@CollectionTable(name = "listDna")
	private List<String> dna;

	@Column(name="simian")
	private boolean simian;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return id == simian.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}