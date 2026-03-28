package fr.uparis.informatique.cours.ig.mvc;

import javax.swing.JLabel;

public class PassiveView3 extends JLabel implements PassiveView { 
	private static final long serialVersionUID = 1L;

	public void update(PassiveModel m) {
		int v = m.getValeur();
		String text = "";
		if (v<10) text = "<10";
		else if (v<20) text = "dans [10,20)";
		else text = "grosse valeur!";
		setText(text);
	}
}
