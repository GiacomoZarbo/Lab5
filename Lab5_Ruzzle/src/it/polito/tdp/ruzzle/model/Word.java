package it.polito.tdp.ruzzle.model;

import java.util.LinkedList;
import java.util.List;

public class Word {

	private String parola;
	private List<Integer> posizioni = new LinkedList<Integer>();

	public Word(String parola, List<Integer> posizioni) {
		this.parola = parola;
		this.posizioni = posizioni;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public void removeParola() {
		this.parola = null;
	}

	public List<Integer> getPosizioni() {
		return posizioni;
	}

	public void setPosizioni(List<Integer> posizioni) {
		this.posizioni = posizioni;
	}

	public void addPosizione(Integer posizione) {
		this.posizioni.add(posizione);
	}

	public void removePosizione(Integer posizione) {
		this.posizioni.add(posizione);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
}
