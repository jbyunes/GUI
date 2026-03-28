package fr.uparis.informatique.cours.ig.mvc;

import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class PassiveView2 extends JSlider implements PassiveView { 
	private static final long serialVersionUID = 1L;
	public PassiveView2() {
		this.setMinimum(0);
		this.setMaximum(100);
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setMinorTickSpacing(10);
		this.setMajorTickSpacing(20);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setEnabled(false);
	}

	public void update(PassiveModel m) {
		this.setValue(m.getValeur());
	}
}
