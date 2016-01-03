package TestJOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestShowInputDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestShowInputDialog frame = new TestShowInputDialog();
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
	public TestShowInputDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u663E\u793A\u8F93\u5165\u6846(showInputDialog)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//在监听器中添加showInputDialog方法
			//第一个参数是message
			//第二个参数是文本框中默认的值
			@Override
			public void mouseClicked(MouseEvent e) {
				//该方法返回的就是文本框中用户输入的值
				//String in = JOptionPane.showInputDialog("Input", "abc");
				
//				String in = JOptionPane.showInputDialog(
//						TestShowInputDialog.this, 
//						"请输入你的密码",
//						"输入",
//						JOptionPane.WARNING_MESSAGE);
				
				//包含下拉菜单的弹出框，通过String类型的数组传入
				String in = (String) JOptionPane.showInputDialog(
						TestShowInputDialog.this,
						"请输入你的密码",
						"输入",
						JOptionPane.WARNING_MESSAGE,
						null,
						new String[]{"选择项1","选择项2", "选择项3"},
						"aaa"
						);
				JOptionPane.showMessageDialog(TestShowInputDialog.this, in);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(btnNewButton)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
