package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class JSplitPaneExemple {
	private static JPanel createPanneauPleinDeBoutons(int n) {
		JPanel panneau = new JPanel();
		for (int i=0; i<n; i++)
			panneau.add(new JButton("Bouton "+Integer.toString(i)));
		panneau.setMinimumSize(new Dimension(100,100));
		panneau.setBorder(BorderFactory.createLineBorder(Color.black,5));
		return panneau;
	}
	public JSplitPaneExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		JSplitPane panneau = new JSplitPane();
		panneau.setContinuousLayout(true);
		panneau.setOneTouchExpandable(true);
		panneau.setLeftComponent(createPanneauPleinDeBoutons(10));
		panneau.setRightComponent(createPanneauPleinDeBoutons(13));
		panneau.setResizeWeight(0.5);
		fenetre.setContentPane(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JSplitPaneExemple();
			}
		});
	}
}
