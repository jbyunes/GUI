package fr.uparis.informatique.cours.ig.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActiveController implements ActionListener {
	private ActiveModel m;
	public ActiveController(ActiveModel m) {
		this.m = m;
	}
	public void actionPerformed(ActionEvent e) {
		m.setValeur(m.getValeur()+1);
	}
}

