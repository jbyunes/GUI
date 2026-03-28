package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MessageDialogExemple implements Runnable {
	public void run() {
		final JFrame fenetre = new JFrame("Fenetre1");
		JLabel l = new JLabel("Une superbe et magnifique fenêtre");
		JButton b = new JButton("Vas-y tapes-moi!");
		l.setPreferredSize(new Dimension(400,400));
		fenetre.getContentPane().setLayout(new BorderLayout());
		fenetre.getContentPane().add(l,BorderLayout.CENTER);
		fenetre.getContentPane().add(b,BorderLayout.SOUTH);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetre,
						"J'ai remarqué que vous étiez fatigué...",
						"Remarque",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new MessageDialogExemple());
	}
}
