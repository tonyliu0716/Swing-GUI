package swingDraw;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	@Override
	protected void printComponent(Graphics g) {
		System.out.println("printComponent...");
		super.paintComponent(g);
	}

	@Override
	protected void printChildren(Graphics g) {
		System.out.println("printChildren...");
		super.paintChildren(g);
	}

	@Override
	protected void printBorder(Graphics g) {
		System.out.println("printBorder...");
		super.paintBorder(g);
	}

	//系统刷新界面时所调用的方法，该方法会自动调用上述的三个方法
	@Override
	public void paint(Graphics g) {
		System.out.println("paint...");
		super.paint(g);
	}
}
