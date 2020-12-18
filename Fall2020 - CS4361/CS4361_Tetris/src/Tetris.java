//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.*;
//
//class Main {
//
//	public static void main(String[] args) {
//		JFrame f=new JFrame("Tetris");
//		
//		Tetris t = new Tetris();
//		f.add(t);
//		f.setSize(500, 600);
//		f.setVisible(true);
//		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
//
//}
//
//class Tetris extends JPanel {
//	
//	Color darkBlue = new Color(0, 93, 255);
//	Color darkGreen = new Color(97, 150, 44);
//	Color black = Color.BLACK;
//	Color white = Color.WHITE;
//	Color red = Color.RED;
//	Color yellow = new Color(255, 178, 44);
//	Color transparent = new Color(255, 255, 255, 0);
//	Font arial = new Font("Arial", Font.BOLD, 18);
//	JButton pause;
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		this.setBackground(white);
//		
//		// Main Playing Area
//		JPanel mainArea = new JPanel();
//		mainArea.setLayout(null);
//		mainArea.setBounds(100,100,200,400);
//		mainArea.setBorder(BorderFactory.createLineBorder(black, 1));
//		mainArea.setOpaque(false);
//		mainArea.addMouseListener(new Pause());
//		add(mainArea);
//		
//		// Square Shape
//		g.setColor(darkGreen);
//		g.fillRect(180, 150, 40, 40);
//		
//		// Horizontal L Shape
//		g.setColor(red);
//		g.fillRect(340, 130, 60, 20);
//		g.fillRect(380, 110, 20, 20);
//		
//		// Vertical L Shape
//		g.setColor(darkBlue);
//		g.fillRect(279, 439, 20, 60);
//		g.fillRect(259, 479, 20, 20);
//		
//		// Z Shape
//		g.setColor(yellow);
//		g.fillRect(239, 459, 40, 20);
//		g.fillRect(219, 479, 40, 20);
//		
//		
//		
//		g.setColor(black);
//		
//		// Next Shape Box
//		g.drawRect(320, 100, 100, 60);
//		
//		// Level, Lines, Score
//		g.setFont(arial);
//		g.drawString("Level:\t\t 1", 320, 250);
//		g.drawString("Lines:\t\t 0", 320, 290);
//		g.drawString("Score:\t\t0", 320, 330);
//		
//		// Square Shape
//		g.drawRect(180, 150, 20, 20);
//		g.drawRect(200, 150, 20, 20);
//		g.drawRect(180, 170, 20, 20);
//		g.drawRect(200, 170, 20, 20);
//		
//		// Horizontal L Shape
//		g.drawRect(340, 130, 20, 20);
//		g.drawRect(360, 130, 20, 20);
//		g.drawRect(380, 130, 20, 20);
//		g.drawRect(380, 110, 20, 20);
//	
//		// Vertical L Shape
//		g.drawRect(279, 439, 20, 20);
//		g.drawRect(279, 459, 20, 20);
//		g.drawRect(279, 479, 20, 20);
//		g.drawRect(259, 479, 20, 20);
//		
//		// Z Shape	
//		g.drawRect(239, 459, 20, 20);
//		g.drawRect(259, 459, 20, 20);
//		g.drawRect(219, 479, 20, 20);
//		g.drawRect(239, 479, 20, 20);
//		
//		// Quit Button
//		JButton quit = new JButton("QUIT");
//		quit.setBounds(320, 470, 80, 30);
//		quit.setFont(arial);
//		quit.setBorder(BorderFactory.createLineBorder(black, 1));
//		quit.setBackground(white);
//		quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		add(quit);
//		quit.addActionListener(new Quit());
//		
//		// Pause Button
//		pause = new JButton("PAUSE");
//		pause.setBounds(150, 230, 100, 30);
//		pause.setFont(arial);
//		pause.setBackground(white);
//		pause.setBorder(BorderFactory.createLineBorder(transparent, 1));
//		pause.setForeground(transparent);
//		add(pause);
//		
//	}
//	
//	class Quit implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.exit(0);
//			
//		}
//		
//	}
//	
//	class Pause implements MouseListener {
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			pause.setBackground(white);
//			pause.setBorder(BorderFactory.createLineBorder(darkBlue, 1));
//			pause.setForeground(darkBlue);
//			pause.setOpaque(true);
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			pause.setBackground(white);
//			pause.setBorder(BorderFactory.createLineBorder(transparent, 1));
//			pause.setForeground(transparent);
//			pause.setOpaque(true);
//		}
//		
//	}
//}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

class Main {

	public static void main(String[] args) {
		JFrame f=new JFrame("Tetris");
		
		Tetris t = new Tetris();
		f.add(t);
		f.setSize(500, 600);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Tetris extends JPanel {
	
	Color darkBlue = new Color(0, 93, 255);
	Color darkGreen = new Color(97, 150, 44);
	Color black = Color.BLACK;
	Color white = Color.WHITE;
	Color red = Color.RED;
	Color yellow = new Color(255, 178, 44);
	Color transparent = new Color(255, 255, 255, 0);
	Font arial = new Font("Arial", Font.BOLD, 18);
	JButton pause;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(white);
		
		// Main Playing Area
		JPanel mainArea = new JPanel();
		mainArea.setLayout(null);
		mainArea.setBounds(100,100,200,400);
		mainArea.setBorder(BorderFactory.createLineBorder(black, 1));
		mainArea.setOpaque(false);
		mainArea.addMouseListener(new Pause());
		add(mainArea);
		
		// Square Shape
		g.setColor(darkGreen);
		g.fillRect(180, 150, 40, 40);
		
		// Horizontal L Shape
		g.setColor(red);
		g.fillRect(340, 130, 60, 20);
		g.fillRect(380, 110, 20, 20);
		
		// Vertical L Shape
		g.setColor(darkBlue);
		g.fillRect(279, 439, 20, 60);
		g.fillRect(259, 479, 20, 20);
		
		// Z Shape
		g.setColor(yellow);
		g.fillRect(239, 459, 40, 20);
		g.fillRect(219, 479, 40, 20);
		
		
		
		g.setColor(black);
		
		// Next Shape Box
		g.drawRect(320, 100, 100, 60);
		
		// Level, Lines, Score
		g.setFont(arial);
		g.drawString("Level:\t\t 1", 320, 250);
		g.drawString("Lines:\t\t 0", 320, 290);
		g.drawString("Score:\t\t0", 320, 330);
		
		// Square Shape
		g.drawRect(180, 150, 20, 20);
		g.drawRect(200, 150, 20, 20);
		g.drawRect(180, 170, 20, 20);
		g.drawRect(200, 170, 20, 20);
		
		// Horizontal L Shape
		g.drawRect(340, 130, 20, 20);
		g.drawRect(360, 130, 20, 20);
		g.drawRect(380, 130, 20, 20);
		g.drawRect(380, 110, 20, 20);
	
		// Vertical L Shape
		g.drawRect(279, 439, 20, 20);
		g.drawRect(279, 459, 20, 20);
		g.drawRect(279, 479, 20, 20);
		g.drawRect(259, 479, 20, 20);
		
		// Z Shape	
		g.drawRect(239, 459, 20, 20);
		g.drawRect(259, 459, 20, 20);
		g.drawRect(219, 479, 20, 20);
		g.drawRect(239, 479, 20, 20);
		
		// Quit Button
		JButton quit = new JButton("QUIT");
		quit.setBounds(320, 470, 80, 30);
		quit.setFont(arial);
		quit.setBorder(BorderFactory.createLineBorder(black, 1));
		quit.setBackground(white);
		quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(quit);
		quit.addActionListener(new Quit());
		
		// Pause Button
		pause = new JButton("PAUSE");
		pause.setBounds(150, 230, 100, 30);
		pause.setFont(arial);
		pause.setBackground(white);
		pause.setBorder(BorderFactory.createLineBorder(transparent, 1));
		pause.setForeground(transparent);
		add(pause);
		
	}
	
	class Quit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	class Pause implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			pause.setBackground(white);
			pause.setBorder(BorderFactory.createLineBorder(darkBlue, 1));
			pause.setForeground(darkBlue);
			pause.setOpaque(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			pause.setBackground(white);
			pause.setBorder(BorderFactory.createLineBorder(transparent, 1));
			pause.setForeground(transparent);
			pause.setOpaque(true);
		}
		
	}
}



