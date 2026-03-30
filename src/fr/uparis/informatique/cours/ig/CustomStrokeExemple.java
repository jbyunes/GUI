package fr.uparis.informatique.cours.ig;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CustomStrokeExemple extends JPanel {
	private GeneralPath dessin;
    private Path2D.Double courbe;
	private Dimension d;
	private Stroke stroke;
	public CustomStrokeExemple() {
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
		d = new Dimension(+2*l+150,h+100);
		stroke = new CustomStroke();
		
		double xStart = 50,  yStart = 50;
        double cp1x = 150,   cp1y = 0;   // Premier point de contrôle (en haut)
        double cp2x = 250,   cp2y = 150;  // Deuxième point de contrôle (en bas)
        double xEnd = 350,   yEnd = 50;

        courbe = new Path2D.Double();
        courbe.moveTo(xStart, yStart);
        courbe.curveTo(cp1x, cp1y, cp2x, cp2y, xEnd, yEnd);
	}
	public Dimension getPreferredSize() {
		return d;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.BLUE);
        g2.draw(courbe);

        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.BLACK);
		g2.translate(50,getSize().getHeight()-50);
		g2.draw(dessin);

		g2.setStroke(stroke);
		g2.translate(getSize().getWidth()/2,0);
		g2.draw(dessin);
		
	}
	public static void main(String []a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame("Custom Stroke Exemple");
				fenetre.setContentPane(new CustomStrokeExemple());
				fenetre.pack();
				fenetre.setVisible(true);
			}
		});
	}
}
