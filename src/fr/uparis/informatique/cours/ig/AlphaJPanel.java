package fr.uparis.informatique.cours.ig;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AlphaJPanel extends JPanel {
	private Dimension d;
	private boolean onOff;
	public AlphaJPanel() {
		d = new Dimension(400,400);
		onOff = false;
		setBackground(Color.LIGHT_GRAY);
	}
	public void switchOn() { onOff = !onOff; repaint(); }
	public Dimension getPreferredSize() { return d; }
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setBackground(getBackground());
		g2.clearRect(0,0,getSize().width,getSize().height);
		g2.setColor(Color.BLACK);
		g2.fillRect(getSize().width/4,getSize().height/4,getSize().width/2,getSize().height/2);

		if (onOff) {
			g2 = (Graphics2D)g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
			g2.setColor(Color.RED);
			g2.fillRect(0,0,getSize().width,getSize().height/2);
			g2.setColor(Color.GREEN);
			g2.fillRect(0,getSize().height/2,getSize().width,getSize().height/2);
		}
	}
}
