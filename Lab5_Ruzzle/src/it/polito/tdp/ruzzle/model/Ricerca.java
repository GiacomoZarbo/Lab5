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
		boolean trovata = false;
		if (step == 16)
			return;
		if (dao.searchSequence(parola.toString().toLowerCase())) {
			if (step >= 2 && dao.isContenutaInDizionario(parola.toString().toLowerCase())) {
				if (paroleTrovate.contains(word))
					trovata = true;
				if (!trovata) {
					word.setParola(parola.toString().toLowerCase());
					word.setPosizioni(posizioni);
					paroleTrovate.add(new Word(word.getParola(), new LinkedList<Integer>(posizioni)));
				}
			}
			if (j - 1 >= 0 && !matrixCharacters[i][j - 1].isUsato()) {
				parola.append(matrixCharacters[i][j - 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i) * 4 + (j - 1));
				matrixCharacters[i][j - 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i, j - 1, step + 1, word, posizioni);
				matrixCharacters[i][j - 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i - 1 >= 0 && j - 1 >= 0 && !matrixCharacters[i - 1][j - 1].isUsato()) {
				parola.append(matrixCharacters[i - 1][j - 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i - 1) * 4 + (j - 1));
				matrixCharacters[i - 1][j - 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i - 1, j - 1, step + 1, word, posizioni);
				matrixCharacters[i - 1][j - 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i - 1 >= 0 && !matrixCharacters[i - 1][j].isUsato()) {
				parola.append(matrixCharacters[i - 1][j].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i - 1) * 4 + (j));
				matrixCharacters[i - 1][j].setUsato(true);
				cercaParola(parola, matrixCharacters, i - 1, j, step + 1, word, posizioni);
				matrixCharacters[i - 1][j].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i - 1 >= 0 && j + 1 <= 3 && !matrixCharacters[i - 1][j + 1].isUsato()) {
				parola.append(matrixCharacters[i - 1][j + 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i - 1) * 4 + (j + 1));
				matrixCharacters[i - 1][j + 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i - 1, j + 1, step + 1, word, posizioni);
				matrixCharacters[i - 1][j + 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (j + 1 <= 3 && !matrixCharacters[i][j + 1].isUsato()) {
				parola.append(matrixCharacters[i][j + 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i) * 4 + (j + 1));
				matrixCharacters[i][j + 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i, j + 1, step + 1, word, posizioni);
				matrixCharacters[i][j + 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i + 1 <= 3 && j + 1 <= 3 && !matrixCharacters[i + 1][j + 1].isUsato()) {
				parola.append(matrixCharacters[i + 1][j + 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i + 1) * 4 + (j + 1));
				matrixCharacters[i + 1][j + 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i + 1, j + 1, step + 1, word, posizioni);
				matrixCharacters[i + 1][j + 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i + 1 <= 3 && !matrixCharacters[i + 1][j].isUsato()) {
				parola.append(matrixCharacters[i + 1][j].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i + 1) * 4 + (j));
				matrixCharacters[i + 1][j].setUsato(true);
				cercaParola(parola, matrixCharacters, i + 1, j, step + 1, word, posizioni);
				matrixCharacters[i + 1][j].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
			if (i + 1 <= 3 && j - 1 >= 0 && !matrixCharacters[i + 1][j - 1].isUsato()) {
				parola.append(matrixCharacters[i + 1][j - 1].getCarattere());
				word.setParola(parola.toString().toLowerCase());
				posizioni.add((i + 1) * 4 + (j - 1));
				matrixCharacters[i + 1][j - 1].setUsato(true);
				cercaParola(parola, matrixCharacters, i + 1, j - 1, step + 1, word, posizioni);
				matrixCharacters[i + 1][j - 1].setUsato(false);
				parola.deleteCharAt(parola.length() - 1);
				word.setParola(parola.toString().toLowerCase());
				posizioni.remove(posizioni.size() - 1);
			}
		}
	}
}
