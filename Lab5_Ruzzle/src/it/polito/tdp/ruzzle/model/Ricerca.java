package it.polito.tdp.ruzzle.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.ruzzle.DAO.DAO;

public class Ricerca {

	DAO dao = new DAO();
	List<Word> paroleTrovate = new LinkedList<Word>();

	public List<Word> trovaParole(Carattere[][] matrixCharacters) {
		StringBuilder parola = new StringBuilder("");
		List<Integer> posizioni = new LinkedList<Integer>();
		paroleTrovate.clear();
		Word word = new Word("", null);
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				for (int x = 0; x <= 3; x++) {
					for (int y = 0; y <= 3; y++) {
						matrixCharacters[x][y].setUsato(false);
					}
				}
				cercaParola(parola, matrixCharacters, i, j, 0, word, posizioni);
			}
		}
		return paroleTrovate;
	}

	private void cercaParola(StringBuilder parola, Carattere[][] matrixCharacters, int i, int j, int step, Word word,
			List<Integer> posizioni) {
		if (dao.searchSequence(parola.toString().toLowerCase())) {
			if (step >= 2 && dao.isContenutaInDizionario(parola.toString().toLowerCase())
					&& !paroleTrovate.contains(word)) {
				word.setParola(parola.toString().toLowerCase());
				word.setPosizioni(posizioni);
				paroleTrovate.add(new Word(word.getParola(), new LinkedList<Integer>(posizioni)));
			}
			if (step == 16)
				return;
			if (j - 1 >= 0 && !matrixCharacters[i][j - 1].isUsato())
				search(parola, matrixCharacters, i, j - 1, step, word, posizioni);
			if (i - 1 >= 0 && j - 1 >= 0 && !matrixCharacters[i - 1][j - 1].isUsato())
				search(parola, matrixCharacters, i - 1, j - 1, step, word, posizioni);
			if (i - 1 >= 0 && !matrixCharacters[i - 1][j].isUsato())
				search(parola, matrixCharacters, i - 1, j, step, word, posizioni);
			if (i - 1 >= 0 && j + 1 <= 3 && !matrixCharacters[i - 1][j + 1].isUsato())
				search(parola, matrixCharacters, i - 1, j + 1, step, word, posizioni);
			if (j + 1 <= 3 && !matrixCharacters[i][j + 1].isUsato())
				search(parola, matrixCharacters, i, j + 1, step, word, posizioni);
			if (i + 1 <= 3 && j + 1 <= 3 && !matrixCharacters[i + 1][j + 1].isUsato())
				search(parola, matrixCharacters, i + 1, j + 1, step, word, posizioni);
			if (i + 1 <= 3 && !matrixCharacters[i + 1][j].isUsato())
				search(parola, matrixCharacters, i + 1, j, step, word, posizioni);
			if (i + 1 <= 3 && j - 1 >= 0 && !matrixCharacters[i + 1][j - 1].isUsato())
				search(parola, matrixCharacters, i + 1, j - 1, step, word, posizioni);
		}
	}

	private void search(StringBuilder parola, Carattere[][] matrixCharacters, int i, int j, int step, Word word,
			List<Integer> posizioni) {
		parola.append(matrixCharacters[i][j].getCarattere());
		word.setParola(parola.toString().toLowerCase());
		posizioni.add((i) * 4 + (j));
		matrixCharacters[i][j].setUsato(true);
		cercaParola(parola, matrixCharacters, i, j, step + 1, word, posizioni);
		matrixCharacters[i][j].setUsato(false);
		parola.deleteCharAt(parola.length() - 1);
		word.setParola(parola.toString().toLowerCase());
		posizioni.remove(posizioni.size() - 1);
	}
}
