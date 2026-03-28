package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class JSliderJSpinnerExemple {
	  public JSliderJSpinnerExemple() {
	    JFrame fenetre = new JFrame(this.getClass().toString());
	    
	    JPanel panneau = new JPanel();

	    JSlider slider = new JSlider(0,100,50);
	    panneau.add(slider);

	    JSlider slider2 = new JSlider(0,100,50);
	    slider2.setMajorTickSpacing(20);
	    slider2.setMinorTickSpacing(10);
	    slider2.setPaintTicks(true);
	    slider2.setPaintLabels(true);
	    slider2.setPaintTrack(false);
	    slider2.setSnapToTicks(true);
	    panneau.add(slider2);

	    JSpinner spinner = new JSpinner(new SpinnerNumberModel(25,0,100,1));
	    panneau.add(spinner);
	    JSpinner spinner2 = new JSpinner(new JSpinnerModel());
	    panneau.add(spinner2);

	    fenetre.add(panneau);
	    fenetre.pack();
	    fenetre.setVisible(true);
	  }
	  public static void main(String []args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new JSliderJSpinnerExemple();
	        }
	      });
	  }
	}
