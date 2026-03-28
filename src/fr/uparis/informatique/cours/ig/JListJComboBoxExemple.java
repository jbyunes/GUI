package fr.uparis.informatique.cours.ig;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JListJComboBoxExemple {
	private static ImageIcon []images = {
			Utils.imageFrom("images/cagrignote.jpeg"),
			Utils.imageFrom("images/cagrimpe.jpeg"),
			Utils.imageFrom("images/capique.jpeg"),
			Utils.imageFrom("images/cajoue.jpeg")
	};
	static String []nombres = { "一 ichi", "二 ni", "三 san", "四 chi" };
	private static JPanel createJComboBoxPanel() {
		JPanel cbPanel = new JPanel();
		cbPanel.setName("ComboBoxes");
		JComboBox<String> cbs = new JComboBox<String>(nombres);
		cbPanel.add(cbs);
		cbs.setEditable(true);
		JComboBox<ImageIcon> cbi = new JComboBox<ImageIcon>(images);
		cbPanel.add(cbi);
		return cbPanel;
	}
	private static JPanel createJListPanel() {
		JPanel lPanel = new JPanel();
		lPanel.setName("Lists");
		JList<String> ls = new JList<String>(nombres);
		lPanel.add(ls);
		JList<ImageIcon> li = new JList<ImageIcon>(images);
		lPanel.add(li);

		return lPanel;
	}
	public JListJComboBoxExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());

		JTabbedPane panneau = new JTabbedPane();
		panneau.add(createJComboBoxPanel());
		panneau.add(createJListPanel());

		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JListJComboBoxExemple();
			}
		});
	}
}
