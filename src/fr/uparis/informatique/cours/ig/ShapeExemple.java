package fr.uparis.informatique.cours.ig;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.font.*;

@SuppressWarnings("serial")
public class ShapeExemple extends JPanel {
	private GeneralPath dessin;
	private Dimension d;
	public ShapeExemple() {
		Font f = new Font("Serif", Font.BOLD, 200);
		FontRenderContext frc = new FontRenderContext(null, false, false);

		dessin = new GeneralPath();

		TextLayout tl = new TextLayout("Bonjour",f,frc);
		Shape s = tl.getOutline(null);
		dessin.append(s.getPathIterator(null),false);
		int l = tl.getPixelBounds(frc,0,0).width;
		int h = tl.getPixelBounds(frc,0,0).height;
		dessin.moveTo(0,20);
		dessin.lineTo(l,20);
		dessin.lineTo(l,30);
		dessin.lineTo(0,30);
		dessin.lineTo(0,20);

		dessin.closePath();
		d = new Dimension(l+100,h+100);
	}
	public Dimension getPreferredSize() {
		return d;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.translate(50,getSize().getHeight()-50);
		g2.draw(dessin);
	}
	public static void main(String []a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame("Shape Exemple");
				fenetre.setContentPane(new ShapeExemple());
				fenetre.pack();
				fenetre.setVisible(true);
			}
		});
	}
}
