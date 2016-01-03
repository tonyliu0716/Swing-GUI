package TestSwingThread;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BadIdea {
	
	//错误，不能直接在主线程中创建UI元素或者更改UI属性
//	public static void main(String[] args){
//		JFrame frame = new JFrame();
//		frame.setTitle("This is a window!");
//		frame.setSize(500, 200);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
	
	//我们应该使用下面的方法创建窗口对象。即使是我们自行使用JFrame，也是相同的！
	public static void main(String[] args){
		
		//Swing是线程不安全的，所有对于UI元素的修改都必须提交给UI线程执行！
		
		//使用SwingUtilities类的invokeLater()或者invokeAndWait()方法
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("This is a window!");
				frame.setSize(500, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
	
}
