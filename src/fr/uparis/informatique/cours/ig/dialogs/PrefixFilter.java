package fr.uparis.informatique.cours.ig.dialogs;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PrefixFilter extends FileFilter {
	private char prefix;
	public PrefixFilter(char p) {
		prefix = p;
	}
	public boolean accept(File f) {
		char c = f.getName().charAt(0);
		return f.isDirectory() ||
				c==Character.toLowerCase(prefix) ||
				c==Character.toUpperCase(prefix);
	}
	public String getDescription() {
		return "Fichiers : ["+Character.toLowerCase(prefix)+Character.toUpperCase(prefix)+"]*";
	}
}
