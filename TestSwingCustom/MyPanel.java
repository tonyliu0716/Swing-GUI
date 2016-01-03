package TestSwingCustom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		//为Graphics2D打开抗锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(255, 255, 255, 140));
		g2d.fillRoundRect(3, 3, getWidth() - 7, getHeight() - 7, 20, 20);
		
		
		g2d.setClip(0, 0, getWidth(), 30);
		//画出白色的背景色
		g2d.setColor(Color.WHITE);
		//画出背景图
		g2d.fillRoundRect(1, 3, getWidth() - 1, getHeight() - 1, 20, 20);
		//移除刚才设定的Clip
		g2d.setClip(null);
		
		
		g2d.setColor(Color.darkGray);
		//为g2d设定笔触
		g2d.setStroke(new BasicStroke(6));
		g2d.drawRoundRect(3, 3, getWidth() - 7, getHeight() - 7, 20, 20);
		
		
		//设置字体
		g2d.setFont(new Font("Arial", Font.BOLD, 16));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("Swing UI Test", 15, 24);
	}
}
