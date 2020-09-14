import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Square");
		Square sq = new Square();
		
		f.add(sq);
		f.setSize(500, 600);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

public class Square extends JPanel {
	
	Point point = new Point(0,0);
	Point A = new Point(0,0);
	Point B = new Point(0,0);
	int count = 0;
	
	public Square() {
		this.setBackground(Color.black);
		this.addMouseListener(new getCoord());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int d = B.x - A.x;
		g.setColor(Color.red);
		g.drawLine(A.x, A.y, A.x - d, A.y);
		g.setColor(Color.blue);
		g.drawLine(A.x - d, A.y, A.x - d, A.y + d);
		g.setColor(Color.red);
		g.drawLine(A.x - d, A.y + d, A.x, A.y + d);
		g.setColor(Color.blue);
		g.drawLine(A.x, A.y + d, A.x, A.y);
		
	}
	
	class getCoord implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			point = e.getPoint();
			count++;
			if (count == 1) {
				A = point;
				System.out.println(count + ": " + A.x + " " + A.y);
			} else if (count == 2) {
				B = point;
				System.out.println(count + ": " + B.x + " " + B.y);
				count = 0;
				repaint();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
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
