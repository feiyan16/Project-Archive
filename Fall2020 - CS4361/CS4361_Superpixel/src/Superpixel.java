
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class Superpixel extends JPanel {
	
	public static void main(String [] args) {
		
		System.out.println("Input absolute path directory for file: ");
		Scanner s = new Scanner(System.in);
		String directory = s.next();
		s.close();
		
		JFrame f = new JFrame("Superpixel");
		Superpixel superpixel = new Superpixel(directory);
		f.add(superpixel);
		f.setSize(1440, 900);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	float rWidth = (float) 10.0, rHeight = (float) 7.5, pixelSize;
	int centerX, centerY, dGrid = 10, maxX, maxY;
	String directory;
	
	Superpixel(String directory) {
		this.directory = directory;
		repaint();
	}
	
	void drawGrid(Graphics g) {
		maxX = getSize().width - 1; 
		maxY = getSize().height - 1;
		pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
		centerX = maxX / 2; 
		centerY = maxY / 2;
		
		for (int x = dGrid; x < maxX; x += dGrid) {
			for (int y = dGrid; y <= maxY; y += dGrid) {
				g.drawLine(x, y, x, y);
			}
		}
	}
	
	void drawLine(Graphics g, int xP, int yP, int xQ, int yQ) {
		int x = xP, y = yP, D = 0, HX = xQ - xP, HY = yQ - yP, c, M, xInc = 1, yInc = 1;
		if (HX < 0) {xInc = -1; HX = -HX;}
		if (HY < 0) {yInc = -1; HY = -HY;}
		if (HY <= HX) {
			c = 2 * HX; M = 2 * HY;
			for (;;) {
				putPixel(g, x, y);
				if (x == xQ) break;
				x += xInc;
				D += M;
				if (D > HX) {y += yInc; D -= c;
			}
		}
		
		} else {
			c = 2 * HY; M = 2 * HX;
			for (;;) {
				putPixel(g, x, y);
				if (y == yQ) break;
				y += yInc; D += M;
				if (D > HY) {x += xInc; D -= c;}
			}
		}
	}
	
	void drawCircle(Graphics g, int xC, int yC, int r) {
		int x = 0, y = r, u = 1, v = 2 * r - 1, E = 0;
		while (x < y) {
			putPixel(g, xC + x, yC + y); // NNE
			putPixel(g, xC + y, yC - x); // ESE
			putPixel(g, xC - x, yC - y); // SSW
			putPixel(g, xC - y, yC + x); // WNW
			x++; E += u; u += 2;
			if (v < 2 * E) {y--; E -= v; v -= 2;}
			if (x > y) break;
			putPixel(g, xC + y, yC + x); // ENE
			putPixel(g, xC + x, yC - y); // SSE
			putPixel(g, xC - y, yC - x); // WSW
			putPixel(g, xC - x, yC + y); // NNW
		}
	}
	
	void putPixel(Graphics g, int x, int y) {
		int x1 = x * 10;
		int y1 = y * 10;
		int h = 10 / 2;
		g.drawOval(x1 - h, y1 - h, 10, 10);
	}
	
	public void paintComponent(Graphics g) {
		
		drawGrid(g);
		
		try {
			File text = new File(directory);
			Scanner scan = new Scanner(text);
			int n = Integer.parseInt(scan.nextLine());
			for (int i = 0; i <= n; i++) {
				
				if (i < n) {
					String line = scan.nextLine();
					String [] arg = line.split(" ");
					int x1 = Integer.parseInt(arg[0]);
					int y1 = Integer.parseInt(arg[1]);
					int x2 = Integer.parseInt(arg[2]);
					int y2 = Integer.parseInt(arg[3]);
					drawLine(g, x1, y1, x2, y2);
				} else {
					String line = scan.nextLine();
					String [] arg = line.split(" ");
					int xC = Integer.parseInt(arg[0]);
					int yC = Integer.parseInt(arg[1]);
					int R = Integer.parseInt(arg[2]);
					drawCircle(g, xC, yC, R);
				}
			}
			
			scan.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
