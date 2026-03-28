package fr.uparis.informatique.cours.ig.mvc;

import javax.swing.JLabel;

public class PassiveView1 extends JLabel implements PassiveView {
	private static final long serialVersionUID = 1L;

	public void update(PassiveModel m) {
		setText("Value="+m.getValeur());
	}
}
