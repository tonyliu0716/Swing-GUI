package TestSwingPaintAPI;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// 1. 在paintComponent中测试画图的方法。一般有draw方法就有fill方法
// 2. 使用Java2D 改善 API的绘制效果
public class MyPanel extends JPanel{
	
	BufferedImage image = null;
	
	public MyPanel() {
		super();
		try {
			image = ImageIO.read(getClass().getResource("img1.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//这个是引入Java2D
		Graphics2D g2d = (Graphics2D)g;
		
		//使得当前的画图支持锯齿消除
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//g.setColor(new Color(220, 220, 0));
		
		//drawRect只是画出边框
		//g.drawRect(0, 0, 100, 100);
		
		//实心填充的方法
		//g.fillRect(0, 0, 20, 20);
		
		//绘制带有圆角的实心矩形
		//g.fillRoundRect(0, 0, 100, 100, 10, 10);
		
		//绘制椭圆 如果宽度和高度相同，就是圆形
		//g.drawOval(20, 20, 200, 100);
		
		//换另外一种颜色
		//g.setColor(new Color(0, 255, 255));
		
		//绘制实心椭圆形
		//g.fillOval(20, 20, 200, 100);
		
		//g.setColor(new Color(0, 0, 255));
		
		//为String设置字体
		//g.setFont(new Font("Arial", Font.BOLD, 20));
		
		//在屏幕画出String
		//g.drawString("Test API", 200, 200);
		
		//画出弧线
		//g.drawArc(0, 0, 200, 200, 0, 90);
		
		//弧线填充之后变成扇形
		//g.fillArc(0, 0, 200, 200, 0, 270);
		
		//画直线
		//g.drawLine(0, 0, 400, 400);
		
		//绘制图像 - 需要在这个Panel的构造函数中添加BufferedImage图像流
//		if(image != null) {
//			//g.drawImage(image, 20, 20, null);
//			g.drawImage(image, 20, 20, 60, 40, null);
//		}
		
		//绘制多边形 - 同理，也有draw方法
		//g.fillPolygon(new int[]{1, 23, 56, 89, 15}, new int[]{10, 3, 155, 54, 43}, 5);
		
		//设置绘图时所用的线段
		g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		//使用Graphics2D进行消除锯齿 - 之前的所有绘制都可以使用这个2D进行重绘
		g2d.fillPolygon(new int[]{1, 23, 56, 89, 15}, new int[]{10, 3, 155, 54, 43}, 5);
		
		//画出一条直线来查看线段效果
		g2d.drawLine(230, 230, 460, 470);
	}

	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		super.paintBorder(g);
	}

}
