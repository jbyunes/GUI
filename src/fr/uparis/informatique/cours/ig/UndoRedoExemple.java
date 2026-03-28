package fr.uparis.informatique.cours.ig;

import java.awt.*;
import javax.swing.*;

public class UndoRedoExemple {
	public static void createUI() {
		UndoRedoModel m = new UndoRedoModel();
		JFrame f = new JFrame("Undo—Redo");
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		UndoRedoLabel l = new UndoRedoLabel();
		m.addObserver(l);
		c.add(l,BorderLayout.NORTH);
		JTextField t = new JTextField(20);
		c.add(t,BorderLayout.SOUTH);

		JMenuBar mb = new JMenuBar();
		JMenu me = new JMenu("Édition");
		JMenuItem undo = new JMenuItem("Annuler");
		JMenuItem redo = new JMenuItem("Rétablir");
		me.add(undo);
		me.add(redo);
		mb.add(me);
		f.setJMenuBar(mb);

		UndoRedoManager man = new UndoRedoManager(undo,redo);
		t.addActionListener(new UndoRedoAction(m,man));

		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(() -> { createUI(); });
	}
}
