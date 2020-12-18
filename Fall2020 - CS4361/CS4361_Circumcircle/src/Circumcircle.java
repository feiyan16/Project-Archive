import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Circumcircle extends JPanel {
	
	static JComboBox<String> menu;
	Point pointA = new Point(0,0);
	Point pointB = new Point(0,0);
	Point pointC = new Point(0,0);
	int count = 0;
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Circumcircle");
		f.setLayout(new BorderLayout());
		Circumcircle c = new Circumcircle();
		f.add(c);
		f.setSize(1440, 900);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	Circumcircle() {
		String[] options = {"Circumcircle", "Quit"};
		menu = new JComboBox<String>(options);	
		menu.addItemListener(new Itemlistener());
		JLabel l = new JLabel("Choose: ");
		add(l);
		add(menu);
		addMouseListener(new Mouselistener());
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		g.drawLine(pointA.x, pointA.y, pointB.x, pointB.y);
		g.drawLine(pointB.x, pointB.y, pointC.x, pointC.y);
		g.drawLine(pointC.x, pointC.y, pointA.x, pointA.y);
		
		g.setColor(Color.BLUE);
		Point AB = new Point(pointB.x - pointA.x, pointB.y - pointA.y);
		Point midAB = new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2);
		Point iAB = new Point(midAB.x + AB.y, midAB.y - AB.x);
		g.drawLine(midAB.x, midAB.y, iAB.x, iAB.y);
		Point BC = new Point(pointC.x - pointB.x, pointC.y - pointB.y);
		Point midBC = new Point((pointB.x + pointC.x) / 2, (pointB.y + pointC.y) / 2);
		Point iBC = new Point(midBC.x + BC.y, midBC.y - BC.x);
		g.drawLine(midBC.x, midBC.y, iBC.x, iBC.y);
		
		g.setColor(Color.RED);
		Point intersection = lineIntersection(midAB, iAB, midBC, iBC);
		g.fillRect(intersection.x - 2, intersection.y - 2, 4, 4);
		
		g.setColor(Color.BLACK);
		int radius = (int)distance(pointA, intersection);
		int x = intersection.x - radius;
		int y = intersection.y - radius;
		g.drawOval(x, y, radius * 2, radius * 2);
		
	}
	
	double distance(Point a, Point b) {
		int d1 = b.x - a.x;
		int d2 = b.y - a.y;
		double dd = (Math.pow(d1, 2) + Math.pow(d2, 2));
		double d = Math.sqrt(dd);
		return d;
	}
	
	Point lineIntersection(Point a, Point b, Point c, Point d) {
		double a1 = b.y - a.y;
		double b1 = a.x - b.x;
		double c1 = a1 * (a.x) + b1 * (a.y);
		
		double a2 = d.y - c.y;
		double b2 = c.x - d.x;
		double c2 = a2 * (c.x) + b2 * (c.y);
		
		double determinant = a1 * b2 - a2 * b1;
		
		if(determinant == 0) {
			return new Point(0,0);
		} else {
			double x = (b2 * c1 - b1 * c2) / determinant;
			double y = (a1 * c2 - a2 * c1) / determinant; 
			return new Point((int)x, (int)y);
		}
		
	}
	
	class Itemlistener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getSource() == menu) {
				if(menu.getSelectedItem() == "Quit") {
					System.exit(0);
				}
			} 
		}
	}

	class Mouselistener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			Point p = e.getPoint();
			count++;
			
			if(count == 1) {
				pointA = p;
			} else if (count == 2) {
				pointB = p;
			} else if (count == 3) {
				pointC = p;
				repaint();
			} else {
				count = 0;
				pointA = pointB = pointC = new Point(0,0);
				repaint();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}