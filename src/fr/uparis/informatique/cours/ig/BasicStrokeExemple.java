package fr.uparis.informatique.cours.ig;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BasicStrokeExemple extends JPanel {
	private GeneralPath dessin;
	private Dimension d;
	private Stroke stroke;
	public BasicStrokeExemple() {
		Font f = new Font("Serif", Font.BOLD, 100);
		FontRenderContext frc = new FontRenderContext(null, false, false);
		dessin = new GeneralPath();

		TextLayout tl = new TextLayout("JBY",f,frc);
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
		d = new Dimension(2*l+150,h+100);

		float []pointilles = { 15.0f, 5.0f };
		stroke = new BasicStroke(5.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,pointilles,0.0f);
		//    stroke = new BasicStroke(15.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND);
	}
	public Dimension getPreferredSize() {
		return d;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.translate(50,getSize().getHeight()-50);
		g2.draw(dessin);

		g2.setStroke(stroke);
		g2.translate(getSize().getWidth()/2,0);
		g2.draw(dessin);
	}
	public static void main(String []a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame("Basic Stroke Exemple");
				fenetre.setContentPane(new BasicStrokeExemple());
				fenetre.pack();
				fenetre.setVisible(true);
			}
		});
	}
}
