package fr.uparis.informatique.cours.ig;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class FontListener implements ActionListener {
	private JLabel l;
	private JFrame c;
	public FontListener(JFrame c,JLabel l) { this.l = l; this.c = c; }
	public void actionPerformed(ActionEvent e) {
		l.setFont(new Font(((JMenuItem)e.getSource()).getText(),Font.PLAIN,24));
		c.pack();
	}
}

