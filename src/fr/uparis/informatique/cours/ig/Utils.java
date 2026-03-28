package fr.uparis.informatique.cours.ig;

import java.net.URL;

import javax.swing.ImageIcon;

public class Utils {
	public static ImageIcon imageFrom(String name) {
		URL url = urlFrom(name);
		System.out.println(name+"="+url);
		return new ImageIcon(url);
	}
	public static URL urlFrom(String name) {
		var c = JListJComboBoxExemple.class;
		var m = c.getModule();
		var cl = m.getClassLoader();
		URL url = cl.getResource(name);
//		System.out.println(url);
		return url;
	}
}
