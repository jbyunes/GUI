package fr.uparis.informatique.cours.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UndoRedoAction implements ActionListener {
	private UndoRedoModel m;
	private UndoRedoManager man;
	public UndoRedoAction(UndoRedoModel m,UndoRedoManager man) {
		this.m = m;
		this.man = man;
	}
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField)e.getSource();
		String s = t.getText();
		try {
			int v = Integer.parseInt(s);
			man.addEdit(new UndoableModification(m,v));
			m.add(v);
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(t,"Ce n'est pas un entier");
		}
		t.setText("0");
	}
}

