package TestComponent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class TextLabel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextLabel frame = new TextLabel();
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
	public TextLabel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblThisIsA = new JLabel("\u8BF7\u5728\u4E0B\u65B9\u8F93\u5165\u5185\u5BB9");
		lblThisIsA.setHorizontalAlignment(SwingConstants.LEFT);
		lblThisIsA.setVerticalAlignment(SwingConstants.TOP);
		lblThisIsA.setToolTipText("click");
		lblThisIsA.setIcon(new ImageIcon(TextLabel.class.getResource("/com/sun/java/swing/plaf/gtk/icons/File.gif")));
		lblThisIsA.setForeground(UIManager.getColor("PasswordField.foreground"));
		lblThisIsA.setFont(new Font("Menlo", Font.BOLD, 18));
		contentPane.add(lblThisIsA, BorderLayout.NORTH);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
