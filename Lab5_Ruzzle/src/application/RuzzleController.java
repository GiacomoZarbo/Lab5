package application;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.ruzzle.model.Model;
import it.polito.tdp.ruzzle.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RuzzleController {

	private Model model;
	private List<Label> labels;
	private List<Word> words;
	boolean creata;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRandomRuzzle;

	@FXML
	private ListView<String> listView;

	@FXML
	private Button btnShow;

	@FXML
	private Label lbl0;

	@FXML
	private Label lbl1;

	@FXML
	private Label lbl2;

	@FXML
	private Label lbl3;

	@FXML
	private Label lbl4;

	@FXML
	private Label lbl5;

	@FXML
	private Label lbl6;

	@FXML
	private Label lbl7;

	@FXML
	private Label lbl8;

	@FXML
	private Label lbl9;

	@FXML
	private Label lbl10;

	@FXML
	private Label lbl11;

	@FXML
	private Label lbl12;

	@FXML
	private Label lbl13;

	@FXML
	private Label lbl14;

	@FXML
	private Label lbl15;

	@FXML
	private Label lblResult;

	@FXML
	void doGenerateRandomRuzzle(ActionEvent event) {
		lblResult.setText("");
		for (Label l : labels)
			l.setStyle("-fx-background-color: green");
		listView.getItems().clear();
		words.clear();
		model.generateRandomRuzzle(labels);
		words = model.trovaParole(labels);
		Collections.sort(words, new RuzzleController.ComparatoreWords());
		for (Word w : words)
			listView.getItems().add(w.getParola().toString().toLowerCase());
		creata = true;
		lblResult.setText("Tavola creata.");
	}

	@FXML
	void doShow(ActionEvent event) {
		lblResult.setText("");
		if (creata) {
			for (Label l : labels)
				l.setStyle("-fx-background-color: green");
			int index = listView.getSelectionModel().getSelectedIndex();
			if (index >= 0) {
				Word word = words.get(index);
				for (Integer i : word.getPosizioni()) {
					labels.get(i).setStyle("-fx-background-color: red");
				}
				lblResult.setText("Fatto.");
			} else {
				lblResult.setText("Selezionare una parola.");
			}
		} else
			lblResult.setText("Creare una tavola Random Ruzzle.");
	}

	@FXML
	void initialize() {
		assert btnRandomRuzzle != null : "fx:id=\"btnRandomRuzzle\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert btnShow != null : "fx:id=\"btnShow\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl0 != null : "fx:id=\"lbl0\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl6 != null : "fx:id=\"lbl6\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl8 != null : "fx:id=\"lbl8\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl9 != null : "fx:id=\"lbl9\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl10 != null : "fx:id=\"lbl10\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl12 != null : "fx:id=\"lbl12\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl14 != null : "fx:id=\"lbl14\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lbl15 != null : "fx:id=\"lbl15\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'Ruzzle.fxml'.";

		words = new LinkedList<Word>();
		labels = new LinkedList<Label>();
		creata = false;

		labels.add(lbl0);
		labels.add(lbl1);
		labels.add(lbl2);
		labels.add(lbl3);
		labels.add(lbl4);
		labels.add(lbl5);
		labels.add(lbl6);
		labels.add(lbl7);
		labels.add(lbl8);
		labels.add(lbl9);
		labels.add(lbl10);
		labels.add(lbl11);
		labels.add(lbl12);
		labels.add(lbl13);
		labels.add(lbl14);
		labels.add(lbl15);
	}

	public class ComparatoreWords implements Comparator<Word> {

		@Override
		public int compare(Word arg0, Word arg1) {
			if (arg0.getParola().length() == arg1.getParola().length())
				return arg0.getParola().compareTo(arg1.getParola());
			return arg0.getParola().length() - arg1.getParola().length();
		}

	}
}