package fr.uparis.informatique.cours.ig;

import javax.swing.*;        
import java.awt.*;
import java.awt.event.*;

public class Bonjour2 {
    private static void creeInterface() {
        JFrame frame = new JFrame("Application Bonjour");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Bonjour!");
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	    });
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Bonjour2::creeInterface);
    }
}