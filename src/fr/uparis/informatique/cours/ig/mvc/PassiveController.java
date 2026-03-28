package fr.uparis.informatique.cours.ig.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PassiveController implements ActionListener {
	private PassiveModel m;
	private List<PassiveView> vues;
	private void changeViews() {
		for (PassiveView v : vues) v.update(m);
	}

	public PassiveController(PassiveModel m ) {
		this.m = m;
		vues = new ArrayList<PassiveView>();
	}
	public void actionPerformed(ActionEvent e) {
		m.setValeur(m.getValeur()+1);
		changeViews();
	}    
	public void addView(PassiveView v) {
		if (vues.contains(v)) return;
		vues.add(v);
		v.update(m);
	}
}
