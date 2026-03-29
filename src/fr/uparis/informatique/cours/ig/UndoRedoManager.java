package fr.uparis.informatique.cours.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

@SuppressWarnings("serial")
public class UndoRedoManager extends UndoManager {
	private JMenuItem annuler, rétablir;
	public UndoRedoManager(JMenuItem a,JMenuItem r) {
		annuler = a;
		rétablir = r;
		annuler.setEnabled(false);
		rétablir.setEnabled(false);
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		rétablir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redo();
			}
		});
	}
	public boolean addEdit(UndoableEdit e) {
		boolean b = super.addEdit(e);
		updateItems();
		return b;
	}
	public void redo() {
		super.redo();
		updateItems();
	}
	public void undo() {
		super.undo();
		updateItems();
	}
	private void updateItems() {
		rétablir.setEnabled(canRedo());
		if (!canRedo()) {
			rétablir.setText("Rétablir");
		} else {
			rétablir.setText(editToBeRedone().getRedoPresentationName());
		}
		annuler.setEnabled(canUndo());
		if (!canUndo()) {
			annuler.setText("Annuler");
		} else {
			annuler.setText(editToBeUndone().getUndoPresentationName());
		}
	}
}

