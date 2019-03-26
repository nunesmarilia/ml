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
	private int id;

	@ElementCollection
	@CollectionTable(name = "data")
	private List<String> dna;

	@Column(name="simian")
	private boolean simian;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return Objects.equals(dna, simian.dna);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dna);
	}
}