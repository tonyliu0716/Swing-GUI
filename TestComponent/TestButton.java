package TestComponent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

//JButton按钮
public class TestButton extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea txtrImportJavaawtborderlayoutPublic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestButton frame = new TestButton();
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
	public TestButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setText("123");
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8BBE\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//textArea.setText(textField.getText());
				System.out.println(textField.getText());
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtrImportJavaawtborderlayoutPublic = new JTextArea();
		txtrImportJavaawtborderlayoutPublic.setText("import java.awt.BorderLayout;\n\n\npublic class TestButton extends JFrame {\n\n\tprivate JPanel contentPane;\n\tprivate JTextField textField;\n\tprivate JTextArea textArea;\n\n\t/**\n\t * Launch the application.\n\t */\n\tpublic static void main(String[] args) {\n\t\tEventQueue.invokeLater(new Runnable() {\n\t\t\tpublic void run() {\n\t\t\t\ttry {\n\t\t\t\t\tTestButton frame = new TestButton();\n\t\t\t\t\tframe.setVisible(true);\n\t\t\t\t} catch (Exception e) {\n\t\t\t\t\te.printStackTrace();\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t}\n\n\t/**\n\t * Create the frame.\n\t */\n\tpublic TestButton() {\n\t\tsetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t\tsetBounds(100, 100, 450, 300);\n\t\tcontentPane = new JPanel();\n\t\tcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));\n\t\tcontentPane.setLayout(new BorderLayout(0, 0));\n\t\tsetContentPane(contentPane);\n\t\t\n\t\ttextField = new JTextField();\n\t\ttextField.setHorizontalAlignment(SwingConstants.CENTER);\n\t\ttextField.setText(\"123\");\n\t\tcontentPane.add(textField, BorderLayout.NORTH);\n\t\ttextField.setColumns(10);\n\t\t\n\t\t\n\t\ttextArea = new JTextArea();\n\t\tcontentPane.add(textArea, BorderLayout.CENTER);\n\t\t\n\t\tJButton btnNewButton = new JButton(\"\\u8BBE\\u5B9A\");\n\t\tbtnNewButton.addMouseListener(new MouseAdapter() {\n\t\t\t@Override\n\t\t\tpublic void mouseClicked(MouseEvent e) {\n\t\t\t\t//textArea.setText(textField.getText());\n\t\t\t\tSystem.out.println(textField.getText());\n\t\t\t}\n\t\t});\n\t\tcontentPane.add(btnNewButton, BorderLayout.SOUTH);\n\t}\n\n}\n");
		scrollPane.setViewportView(txtrImportJavaawtborderlayoutPublic);
	}

}
