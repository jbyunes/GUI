package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneExemple {
	public static void addPanneau(JTabbedPane tp,String onglet,
			String texte) {
		JPanel panneau = new JPanel();
		JLabel etiquette = new JLabel("<html>"+texte+"</html>");
		etiquette.setToolTipText("Pierre Dac");
		tp.addTab(onglet,etiquette);
	}
	public JTabbedPaneExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		JTabbedPane panneau = new JTabbedPane();
		addPanneau(panneau,"n°1","Les bons crus font les bonnes cuites.");
		addPanneau(panneau,"n°2","J’ai toujours été surpris qu’un record battu ne se soit jamais plaint.");
		addPanneau(panneau,"n°3","Rien ne sert de penser, il faut réfléchir avant.");
		fenetre.getContentPane().add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTabbedPaneExemple();
			}
		});
	}
}
