package fr.uparis.informatique.cours.ig;
import javax.swing.*;

public class ButtonsExemple {
	private static JPanel createJButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setName("Buttons");
		buttonPanel.add(new JButton("Click on me!"));
		buttonPanel.add(new JButton("Me too!"));
		return buttonPanel;
	}
	private static JPanel createJCheckBoxPanel() {
		JPanel cbPanel = new JPanel();
		cbPanel.setName("Checkboxes");
		cbPanel.add(new JLabel("Qu'est ce tu souhaites ?"));
		cbPanel.add(new JCheckBox("Entrée"));
		cbPanel.add(new JCheckBox("Plat"));
		cbPanel.add(new JCheckBox("Fromage"));
		cbPanel.add(new JCheckBox("Dessert"));
		return cbPanel;
	}
	private static JPanel createJRadioButtonPanel() {
		JPanel rbPanel = new JPanel();
		rbPanel.setName("Radios");
		rbPanel.add(new JLabel("Choisit ta chaîne :"));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rb = new JRadioButton("Mezzo");
		rb.setSelected(true);
		bg.add(rb);
		rbPanel.add(rb);
		rb = new JRadioButton("Motor TV");
		bg.add(rb);
		rbPanel.add(rb);
		rb = new JRadioButton("Odyssée");
		bg.add(rb);
		rbPanel.add(rb);
		rb = new JRadioButton("Equidia");
		bg.add(rb);
		rbPanel.add(rb);
		return rbPanel;
	}
	public static void createUI() {
		JFrame fenetre = new JFrame(ButtonsExemple.class.toString());

		JTabbedPane panneau = new JTabbedPane();
		panneau.add(createJButtonPanel());
		panneau.add(createJCheckBoxPanel());
		panneau.add(createJRadioButtonPanel());

		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(ButtonsExemple::createUI);
	}
}
