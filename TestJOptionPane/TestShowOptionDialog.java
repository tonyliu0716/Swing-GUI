package TestJOptionPane;

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

public class TestShowOptionDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestShowOptionDialog frame = new TestShowOptionDialog();
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
	public TestShowOptionDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u663E\u793A\u591A\u9879\u9009\u62E9\u6846(showOptionDialog)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//使用showOptionDialog显示多项选择框
			//第一个参数是parentContent
			//第二个参数是message
			//第三个参数是title
			//第四个参数是optionType
			//第五个参数是messageType
			//第六个参数是icon,
			//第七个参数是options
			//第八个参数是默认的初始化参数initialValue
			//
			@Override
			public void mouseClicked(MouseEvent e) {
				String options[] = {"计划A","计划B","计划C","计划D","计划E"};
				int value = JOptionPane.showOptionDialog(
						TestShowOptionDialog.this, 
						"选择一个适合你的计划", 
						"选择计划", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						options, 
						"计划A");
				
				//根据返回值判断
				if(value != JOptionPane.CLOSED_OPTION) {
					switch(value) {
					case 0:
						System.out.println("计划A");
						break;
					case 1:
						System.out.println("计划B");
						break;
					case 2:
						System.out.println("计划C");
						break;
					case 3:
						System.out.println("计划D");
						break;
					case 4:
						System.out.println("计划E");
						break;
					}
				} else {
					System.exit(0);
				}
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
					.addGap(64)
					.addComponent(btnNewButton)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
