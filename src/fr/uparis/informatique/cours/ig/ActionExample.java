package fr.uparis.informatique.cours.ig;
import module java.desktop;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;


class Ecouteur extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public Ecouteur(String s) {
		ImageIcon image = new ImageIcon(Ecouteur.class.getResource("/images/coucou.gif"));
		super(s,image);
		putValue(NAME,"blibli!");
		putValue(SHORT_DESCRIPTION,"Yo man!");
		putValue(MNEMONIC_KEY,KeyEvent.VK_B);
		putValue(DISPLAYED_MNEMONIC_INDEX_KEY,3);
	}
	public Ecouteur(String s,Icon i) { super(s,i); }
	public Ecouteur() {}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Yo!");
	}
}

public class ActionExample {
	public static void createUI() {
		JFrame f = new JFrame("ActionExample");
		JButton b = new JButton("Click on me!");
		Ecouteur e = new Ecouteur("blabla!");
		//	e.putValue(Action.ACTION_COMMAND_KEY,"blibli!");
		b.setAction(e);
		f.getContentPane().add(b);
		JButton b2 = new JButton("fdhjkfsdhfkjsdhk");
		b2.setAction(e);
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(b2);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String a[]) {
		SwingUtilities.invokeLater(ActionExample::createUI);
	}
}
