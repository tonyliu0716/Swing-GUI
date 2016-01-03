package TestJOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//使用JOptionPane.showConfirmDialog 显示弹出信息
public class TestShowConfirmDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestShowConfirmDialog frame = new TestShowConfirmDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestShowConfirmDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u663E\u793A\u786E\u8BA4\u6846(showConfirmDialog)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//1. 执行关闭动作时，显示确认框的基本用法
//				int value = JOptionPane.showConfirmDialog(TestDialog.this, "确定关闭吗？");
//				if(value == JOptionPane.YES_OPTION) {
//					System.exit(0);
//				} else if(value == JOptionPane.CANCEL_OPTION) {
//					System.out.println("You selected Canel...");
//				} else if(value == JOptionPane.NO_OPTION) {
//					System.out.println("You selected No...");
//				} else if(value == JOptionPane.CLOSED_OPTION) {
//					System.out.println("You directly closed the window...");
//				}
				
				
				//2. 直接演示第三种构造方法
				//第一个参数是现在的JOptionPane所在的父类
				//第二个参数是message
				//第三个参数是title
				//第四个参数是optionType，即给用户多少个选择，下面选择的是Yes或者No
				//第五个参数是messageType，决定退出图标的样式
				int value = JOptionPane.showConfirmDialog(
						TestShowConfirmDialog.this, 
						"你确认要退出程序吗？",
						"请确认", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.WARNING_MESSAGE);
				if(value == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(233, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
