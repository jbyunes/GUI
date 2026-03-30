package fr.uparis.informatique.cours.ig;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JSlider;

public class WheelListener implements MouseWheelListener {
	private JSlider s;
	public WheelListener(JSlider s) { this.s = s; }
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		s.setValue(s.getValue()-e.getUnitsToScroll());
		System.out.println(e);
	}
}

