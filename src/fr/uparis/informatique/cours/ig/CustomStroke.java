package fr.uparis.informatique.cours.ig;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;

public class CustomStroke implements Stroke {
	private void fuzz(float []f,int l) {
		for (int i=0; i<l; i++) {
			f[i] += (float)((Math.random()-0.5) * 10.0);
		}
	}
	public Shape createStrokedShape(Shape p) {
		GeneralPath s = new GeneralPath();
		float[] c = new float[6];
		for (PathIterator i = p.getPathIterator(null); !i.isDone(); i.next()) {
			int type = i.currentSegment(c);
			switch (type) {
			case PathIterator.SEG_MOVETO:
				fuzz(c, 2);
				s.moveTo(c[0], c[1]);
				break;
			case PathIterator.SEG_LINETO:
				fuzz(c, 2);
				s.lineTo(c[0], c[1]);
				break;
			case PathIterator.SEG_QUADTO:
				fuzz(c, 4);
				s.quadTo(c[0], c[1], c[2], c[3]);
				break;
			case PathIterator.SEG_CUBICTO:
				fuzz(c, 6);
				s.curveTo(c[0], c[1], c[2], c[3], c[4], c[5]);
				break;
			case PathIterator.SEG_CLOSE:
				s.closePath();
				break;
			}
		}
		Stroke stroke = new BasicStroke((int)(Math.random()*5)+2);
		return stroke.createStrokedShape(s);
	}
}