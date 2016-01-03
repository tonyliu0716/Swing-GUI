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

public class TestShowMessageDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestShowMessageDialog frame = new TestShowMessageDialog();
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
	public TestShowMessageDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u663E\u793A\u6D88\u606F\u6846(showMessageDialog)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//在mouseClicked中利用静态方法直接调用showMessageDialog方法,这个方法中无论点击什么，都是退出
			//第一个参数是parentContent
			//第二个参数是message
			//第三个参数是title
			//第四个参数是messageType
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(
						TestShowMessageDialog.this, 
						"Null Pointer Exception", 
						"ERROR", 
						JOptionPane.ERROR_MESSAGE);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(btnNewButton)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
