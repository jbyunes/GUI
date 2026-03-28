package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ComposeExemple extends JPanel implements ItemListener, ChangeListener {
	ComposePanel comp;
	JLabel alphaLabel, rulesLabel;
	JSlider alphaSlider;
	JComboBox<String> rules;
	int rule = 0;
	float alpha = 1.0f;

	public ComposeExemple() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		GridBagConstraints l = new GridBagConstraints();
		l.gridx = 0;
		l.gridy = 0;
		l.gridheight = 1;
		l.gridwidth = 1;
		l.weightx = 5.0;
		l.fill = GridBagConstraints.BOTH;
		alphaLabel = new JLabel();
		alphaLabel.setText("Alpha");
		alphaLabel.setHorizontalAlignment(JLabel.CENTER);
		layout.setConstraints(alphaLabel, l);
		add(alphaLabel);

		l.gridx = 1;
		l.gridy = 0;
		l.gridwidth = 1;
		l.gridwidth = 1;
		l.weightx = 0;
		rulesLabel = new JLabel();
		rulesLabel.setText("Rules");
		rulesLabel.setHorizontalAlignment(JLabel.CENTER);
		layout.setConstraints(rulesLabel, l);
		add(rulesLabel);   

		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 0;
		a.gridy = 1;
		a.gridheight = 1;
		a.gridwidth = 1;
		a.weightx = 5.0;
		a.fill = GridBagConstraints.BOTH;
		alphaSlider = new JSlider(0,100,100);
		alphaSlider.setMajorTickSpacing(10);
		alphaSlider.setMinorTickSpacing(1);
		alphaSlider.setPaintTicks(true);
		alphaSlider.addChangeListener(this);
		layout.setConstraints(alphaSlider, a);
		add(alphaSlider);

		a.gridx = 1;
		a.gridy = 1;
		a.weightx = 0;
		a.gridheight = 1;
		a.gridwidth = 1;
		rules = new JComboBox<String>();
		layout.setConstraints(rules, a);
		rules.addItem("SRC");
		rules.addItem("DST_IN");
		rules.addItem("DST_OUT");
		rules.addItem("DST_OVER");
		rules.addItem("SRC_IN");
		rules.addItem("SRC_OVER");
		rules.addItem("SRC_OUT");
		rules.addItem("CLEAR");
		rules.addItem("XOR");
		rules.addItemListener(this);
		add(rules);

		GridBagConstraints fC = new GridBagConstraints(); 
		fC.gridx = 0;
		fC.gridy = 2;
		fC.gridheight = 1;
		fC.gridwidth = 2;
		fC.fill = GridBagConstraints.BOTH;
		fC.weightx = 6.0;
		fC.weighty = 1.0;
		comp = new ComposePanel();
		layout.setConstraints(comp, fC);
		add(comp); 
	}

	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider)e.getSource();
		alpha = slider.getValue()/100.0f;
		comp.changeRule(alpha, rule);
	}

	public void itemStateChanged(ItemEvent e){
		if ( e.getStateChange() != ItemEvent.SELECTED ) return;
		rule = rules.getSelectedIndex();
		comp.changeRule(alpha, rule);
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new JFrame("ComposeExample");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ComposeExemple panneau = new ComposeExemple();
				f.getContentPane().add(panneau);
				f.pack();
				f.setSize(new Dimension(300,300));
				f.setVisible(true);
			}
		});
	}
}

