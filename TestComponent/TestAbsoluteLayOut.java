package TestComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

//使用绝对布局，同时使用SwingWorker把Jlabel动起来
public class TestAbsoluteLayOut extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestAbsoluteLayOut frame = new TestAbsoluteLayOut();
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
	public TestAbsoluteLayOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 6, 438, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SwingWorker<String, Integer>() {
					int oriy = lblNewLabel.getY();
					@Override
					protected String doInBackground() throws Exception {
						while(true) {
							Thread.sleep(50);
							publish((int)(Math.cos(System.currentTimeMillis()/100) * 50));
						}
					}

					@Override
					protected void process(List<Integer> chunks) {
						for(int y : chunks) {
							lblNewLabel.setLocation(lblNewLabel.getX(), oriy + y);
						}
						super.process(chunks);
					}
					
				}.execute();
			}
		});
		btnNewButton.setBounds(266, 58, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(16, 46);
		lblNewLabel.setSize(200, 50);
		lblNewLabel.setBackground(Color.blue);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
	}
}
