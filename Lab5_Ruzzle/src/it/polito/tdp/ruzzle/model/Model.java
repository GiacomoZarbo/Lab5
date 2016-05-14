package it.polito.tdp.ruzzle.model;

import java.util.List;
import java.util.Random;

import it.polito.tdp.ruzzle.DAO.DAO;
import javafx.scene.control.Label;

public class Model {

	Ricerca ricerca;
	DAO dao;

	public Model() {
		ricerca = new Ricerca();
		dao = new DAO();
	}

	public void generateRandomRuzzle(List<Label> labels) {
		Random r = new Random();
		String alphabetIta = "ABCDEFGHILMNOPQRSTUVZ";
		// String alphabetEng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (Label l : labels)
			l.setText("" + alphabetIta.charAt(r.nextInt(21)));
	}

	public List<Word> trovaParole(List<Label> labels) {
		Carattere matrixCharacters[][] = new Carattere[4][4];
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrixCharacters[i][j] = new Carattere(labels.get(k).getText().charAt(0), k);
				k++;
			}
		}
		List<Word> words = ricerca.trovaParole(matrixCharacters);
		return words;
	}

	public boolean isContenutaInDizionario(String parola) {
		return dao.isContenutaInDizionario(parola);
	}
}
