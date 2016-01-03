package TestComponent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TestJList extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJList frame = new TestJList();
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
	public TestJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"Java", "SQL", "C#", "Ruby"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		contentPane.add(list, BorderLayout.NORTH);
		
		label = new JLabel(" ");
		contentPane.add(label, BorderLayout.CENTER);
		
		JButton btnGet = new JButton("get");
		btnGet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] v = list.getSelectedValues();
				StringBuilder builder = new StringBuilder("You selected ");
				for(int i =0; i < v.length; i++) {
					builder.append(v[i] + " ");
				}
				label.setText(builder.toString());
			}
		});
		contentPane.add(btnGet, BorderLayout.SOUTH);
	}

}
