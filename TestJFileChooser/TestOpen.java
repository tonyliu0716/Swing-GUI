package TestJFileChooser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

//使用JFileChooser文件选择器打开文件  使用该类对象的showOpenDialog方法

public class TestOpen extends JFrame {

	private JPanel contentPane;
	private JFileChooser chooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestOpen frame = new TestOpen();
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
	public TestOpen() {
		//先实例化JFileChooser
		chooser = new JFileChooser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Open File");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = chooser.showOpenDialog(TestOpen.this);
				//如果有文件被成功的返回
				if(value == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					System.out.println(file.getAbsolutePath());
				}
			}
		});
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOpenDirectory = new JButton("Open Directory");
		btnOpenDirectory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//静态方法的意思是可以选择文件及文件夹都可以，一般情况下只能选择文件
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				//可以选择多个选项
				chooser.setMultiSelectionEnabled(true);
				int value = chooser.showOpenDialog(TestOpen.this);
				//如果有文件被成功的返回
				if(value == JFileChooser.APPROVE_OPTION) {
//					File file = chooser.getSelectedFile();
//					System.out.println(file.getAbsolutePath());
					File[] files = chooser.getSelectedFiles();
					for(int i = 0; i < files.length; i++) {
						System.out.println(files[i].getAbsolutePath());
					}
				}
			}
		});
		contentPane.add(btnOpenDirectory);
		contentPane.add(btnNewButton);
	}

}
