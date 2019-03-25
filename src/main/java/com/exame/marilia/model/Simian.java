package com.exame.marilia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name="dnas")
public class Simian {

	@Column(name="dna")
	private String[] dna;

	@Column(name="simian")
	private boolean simian;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
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
