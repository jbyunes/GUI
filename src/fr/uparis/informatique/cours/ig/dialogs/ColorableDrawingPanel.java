package fr.uparis.informatique.cours.ig.dialogs;

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
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public @SuppressWarnings("serial")
class ColorableDrawingPanel extends JPanel implements MouseListener,MouseMotionListener,Printable,ChangeListener {
	private int x, y, ox, oy;
	private Dimension dim;
	private BufferedImage bi;
	private Graphics2D gi;
	public ColorableDrawingPanel() {
		setBackground(Color.WHITE);
		dim = new Dimension(500,500);
		addMouseListener(this);
	}
	public void mousePressed(MouseEvent m) {
		ox = m.getX();
		oy = m.getY();
		addMouseMotionListener(this);
	}
	public void mouseReleased(MouseEvent m) {
		removeMouseMotionListener(this);
	}
	public void mouseEntered(MouseEvent m) { }
	public void mouseExited(MouseEvent m) { }
	public void mouseClicked(MouseEvent m) { }
	public Dimension getPreferredSize() { return dim; }

	public int print(Graphics g,PageFormat pf,int index) throws PrinterException {
		if (index>0) return Printable.NO_SUCH_PAGE; // So, where is jimmy?
		double scaleX = (double)pf.getImageableWidth() / bi.getWidth();
		double scaleY = (double)pf.getImageableHeight() / bi.getHeight();
		double scale = Math.min(scaleX,scaleY);  //Get minimum scale factor to respect ratio
		System.out.println(scale);
		AffineTransform scaling = new AffineTransform();
		scaling.scale(scale,scale);

		((Graphics2D)g).translate(pf.getImageableX(), pf.getImageableY()); // offset jump
		((Graphics2D)g).drawImage(bi,scaling,null); // do the trick at 300 DPI
		return Printable.PAGE_EXISTS;
	}
	public void paintComponent(Graphics g) {
		if (bi==null) { // create on off-screen if needed
			Graphics2D g2 = (Graphics2D)g;
			bi = g2.getDeviceConfiguration().createCompatibleImage((int)dim.getWidth(),(int)dim.getHeight());
			gi = (Graphics2D)bi.getGraphics();
			gi.setColor(getBackground());
			gi.fillRect(0,0,(int)dim.getWidth(),(int)dim.getHeight());
			gi.setColor(Color.BLACK);
		}
		g.drawImage(bi,0,0,null); // do the trick at 72 DPI
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX(); // get a pos
		y = e.getY();
		gi.setColor(getForeground());
		gi.drawLine(ox,oy,x,y); // draw it on off-screen image
		ox = x; // remember the pos
		oy = y;
		repaint(); // do the trick on screen
	}
	public void mouseMoved(MouseEvent e) { }
	public void stateChanged(ChangeEvent e) {
		setForeground(((ColorSelectionModel)(e.getSource())).getSelectedColor());
	}
	public void setImage(BufferedImage b) {
		this.bi = b;
		this.gi = (Graphics2D)(b.getGraphics());
		this.invalidate();
		dim = new Dimension(b.getWidth(),b.getHeight());
		this.getParent().invalidate();
		this.getParent().validate();
		this.repaint();
	}
	public BufferedImage getImage() {
		return this.bi;
	}
}

