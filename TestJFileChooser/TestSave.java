package TestJFileChooser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

//1. 使用JFileChooser文件选择器保存文件  使用该类对象的showSaveDialog方法
//2. 使用JFileChooser文件选择器设定文件的扩展名过滤 FileNameExtensionFilter类
public class TestSave extends JFrame {

	private JPanel contentPane;
	private JFileChooser chooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSave frame = new TestSave();
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
	public TestSave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooser = new JFileChooser();
				//新建立一个FileNameExtensionFilter
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Allowed Files", "txt", "jar");
				//将该filter传入，设置到chooser中
				chooser.setFileFilter(filter);
				
				try {
					int value = chooser.showSaveDialog(TestSave.this);
					if(value == JFileChooser.APPROVE_OPTION) {
						
						File newFile = chooser.getSelectedFile();
						if (newFile.exists() == false) {
							newFile.createNewFile();
						}
						System.out.println(chooser.getSelectedFile().getAbsolutePath());
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnSave, BorderLayout.NORTH);
	}

}
