package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel implements MouseListener,MouseMotionListener,Printable {
	private int x, y, ox, oy;
	private Dimension dim;
	private BufferedImage bi;
	private Graphics gi;
//	private AffineTransform scaling;
	int compteur;
	public DrawingPanel() {
		super();
		setBackground(Color.WHITE);
		dim = new Dimension(500,500);
		addMouseListener(this);
		compteur = 0;
	}
	public void mousePressed(MouseEvent m) {
		ox = m.getX();
		oy = m.getY();
		addMouseMotionListener(this);
		System.out.println("On détecte les mouvements "+ox+","+oy);
	}
	public void mouseReleased(MouseEvent m) {
		removeMouseMotionListener(this);
		System.out.println("On ne détecte plus les mouvements");
	}
	public void mouseEntered(MouseEvent m) { }
	public void mouseExited(MouseEvent m) { }
	public void mouseClicked(MouseEvent m) { }
	public Dimension getPreferredSize() { return dim; }

	/**
	 * Fonction d'impression stupide...
	 * Le dessin est répété sur 4 pages...
	 */
	public int print(Graphics g, PageFormat pf, int index) throws PrinterException {
		System.out.println("print("+index+")");
		double scaleX = (double)pf.getImageableWidth() / bi.getWidth();
		double scaleY = (double)pf.getImageableHeight() / bi.getHeight();
		double scale = Math.min(scaleX,scaleY);  //Get minimum scale factor to respect ratio
		System.out.println(scale);
		AffineTransform scaling = new AffineTransform();
		scaling.scale(scale,scale);

		if (index>3) return Printable.NO_SUCH_PAGE; // So, where is jimmy?
		((Graphics2D)g).translate(pf.getImageableX(), pf.getImageableY()); // offset jump
		((Graphics2D)g).drawImage(bi,scaling,null);
		return Printable.PAGE_EXISTS;
	}
	public void paintComponent(Graphics g) {
		if (bi==null) { // create on off-screen if needed
			System.out.println("Creation de l'image initiale");
			bi = ((Graphics2D)g).getDeviceConfiguration().createCompatibleImage((int)dim.getWidth(),(int)dim.getHeight());
			gi = bi.getGraphics();
			gi.setColor(getBackground());
			gi.fillRect(0,0,(int)dim.getWidth(),(int)dim.getHeight());
			gi.setColor(Color.BLACK);
		}
		System.out.println("On dessine!");
		g.drawImage(bi,0,0,null); // do the trick at 72 DPI
	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("Un mouvement! "+compteur++);
		x = e.getX(); // get a pos
		y = e.getY();
		gi.setColor(Color.BLACK);
		gi.drawLine(ox,oy,x,y); // draw it on off-screen image
		ox = x; // remember the pos
		oy = y;
		repaint(); // do the trick on screen
	}
	public void mouseMoved(MouseEvent e) { }
}

