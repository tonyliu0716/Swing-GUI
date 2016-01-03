package TestSwingCustom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MyFrame extends JFrame {

	private MyPanel contentPane;
	//用于实现按住鼠标移动窗口功能
	int mx, my, jfx, jfy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setUndecorated(true);
		//用于实现点击按钮退出
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == 0) {
					System.exit(0);		
				}
			}
		});
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new MyPanel();
		
		//当鼠标拖拽的时候location随着鼠标进行改动
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(jfx + (e.getXOnScreen() - mx), jfy + (e.getYOnScreen() - my));
			}
		});
		//mx是屏幕上的X轴
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mx = e.getXOnScreen();
				my = e.getYOnScreen();
				jfx = e.getX();
				jfy = e.getY();
			}
		});

		contentPane.setOpaque(false);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(6, 32, 438, 262);
		contentPane.add(panel);
		
		JButton btnExit = new JButton("Exit");
		
		//使用自定义的MyButtonUI进行自定义外观设计
		btnExit.setUI(new MyButtonUI());
		
		//该功能用于实现点击MAX窗口最大化
		JButton btnNewButton = new JButton("MAX");
		
		//使用自定义的ButtonUI组件
		btnNewButton.setUI(new MyButtonUI());
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getExtendedState() == JFrame.MAXIMIZED_BOTH) {
					setExtendedState(JFrame.NORMAL);
				} else {
					setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
				
			}
		});
		
		//该功能用于实现点击MIN窗口最小化
		JButton btnMin = new JButton("MIN");
		
		//使用自定义的ButtonUI进行自定义外观设计
		btnMin.setUI(new MyButtonUI());
		
		btnMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addComponent(btnMin)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnExit)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnNewButton)
						.addComponent(btnMin))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);		
			}
		});
	}

}
