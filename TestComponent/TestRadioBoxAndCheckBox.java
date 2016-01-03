package TestComponent;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


public class TestRadioBoxAndCheckBox extends JFrame {

	private JPanel contentPane;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JButton btnGet;
	private JPanel panel_1;
	private JCheckBox t2_1;
	private JCheckBox t2_2;
	private JCheckBox t2_3;
	private JLabel t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestRadioBoxAndCheckBox frame = new TestRadioBoxAndCheckBox();
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
	public TestRadioBoxAndCheckBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//对radioButton进行
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9009\u62E9\u98981", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u9009\u62E9\u98982", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		
		t2_1 = new JCheckBox("Java");
		
		t2_2 = new JCheckBox("SQL");
		
		t2_3 = new JCheckBox("C#");
		
		JButton btnNewButton = new JButton("get");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringBuilder builder = new StringBuilder("You selected ");
				if(t2_1.isSelected()) {
					builder.append("+Java");
				}
				if(t2_2.isSelected()) {
					builder.append("+SQL");
				}
				if(t2_3.isSelected()) {
					builder.append("+C#");
				}
				t2.setText(builder.toString());
			}
		});
		
		t2 = new JLabel(" ");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(t2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(t2_1)
						.addComponent(t2_2)
						.addComponent(t2_3)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(t2_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t2_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t2_3)
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(t2)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		r1 = new JRadioButton("Option 1");
		r1.setSelected(true);
		group.add(r1);
		
		r2 = new JRadioButton("Option 2");
		group.add(r2);
		
		r3 = new JRadioButton("Option 3");
		r3.setSelected(true);
		group.add(r3);
		
		btnGet = new JButton("get");
		btnGet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(r1.isSelected()) {
					btnGet.setText("1");
				}else if(r2.isSelected()) {
					btnGet.setText("2");
				}else if(r3.isSelected()) {
					btnGet.setText("3");
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(r3)
						.addComponent(r1))
					.addContainerGap(190, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(r2)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnGet, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(r3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(r1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(r2)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnGet))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
