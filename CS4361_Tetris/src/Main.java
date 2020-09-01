import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame f=new JFrame("Tetris");
		
		Tetris t = new Tetris();
		f.add(t);
		f.setSize(500, 600);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
