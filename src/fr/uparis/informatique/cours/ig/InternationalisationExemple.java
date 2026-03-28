package fr.uparis.informatique.cours.ig;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class InternationalisationExemple {
	public static void createUI() {
		//Locale versionLocale = new Locale("en","EN"); // français de FRance en dur
		ResourceBundle messages = ResourceBundle.getBundle("LesMessages"); //,versionLocale);
		JFrame maJFrame = new JFrame(messages.getString("Coucou"));
		JLabel nord = new JLabel(messages.getString("Nord"),SwingConstants.CENTER);
		JLabel sud = new JLabel(messages.getString("Sud"),SwingConstants.CENTER);
		JLabel est = new JLabel(messages.getString("Est"));
		JLabel ouest = new JLabel(messages.getString("Ouest"));
		JLabel centre = new JLabel(messages.getString("Centre"),SwingConstants.CENTER);
		maJFrame.getContentPane().add(nord,BorderLayout.NORTH);
		maJFrame.getContentPane().add(sud,BorderLayout.SOUTH);
		maJFrame.getContentPane().add(est,BorderLayout.EAST);
		maJFrame.getContentPane().add(ouest,BorderLayout.WEST);
		maJFrame.getContentPane().add(centre,BorderLayout.CENTER);
		maJFrame.pack(); // rangement «optimal»
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(InternationalisationExemple::createUI);	
	}
}
