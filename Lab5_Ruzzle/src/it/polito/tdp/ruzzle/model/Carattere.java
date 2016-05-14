package it.polito.tdp.ruzzle.model;

public class Carattere {

	private char carattere;
	private boolean usato;
	private int posizione;

	public Carattere(char carattere, int posizione) {
		this.carattere = carattere;
		this.usato = false;
		this.posizione = posizione;
	}

	public char getCarattere() {
		return carattere;
	}

	public void setCarattere(char carattere) {
		this.carattere = carattere;
	}

	public boolean isUsato() {
		return usato;
	}

	public void setUsato(boolean usato) {
		this.usato = usato;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carattere;
		result = prime * result + posizione;
		result = prime * result + (usato ? 1231 : 1237);
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
		Carattere other = (Carattere) obj;
		if (carattere != other.carattere)
			return false;
		if (posizione != other.posizione)
			return false;
		if (usato != other.usato)
			return false;
		return true;
	}
}
