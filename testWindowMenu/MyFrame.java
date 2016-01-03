package testWindowMenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 1.窗口菜单栏的绘制，包括菜单栏，图标icon设置，文字设定，以及分割线separator
 * 2.弹出式菜单的创建与使用 JPopupMenu
 * 3.为MacOS X系统优化菜单栏 解决的问题： 一，屏幕最左上角显示的是类的名字  
 *                                    二， 苹果的菜单栏应该显示在屏幕的最左上角
 * 
 * 4.解决上述问题最关键的两行代码：
 *    System.setProperty("apple.laf.useScreenMenuBar", "true");
 *    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "");
 */ 

public class MyFrame extends JFrame {
	
	private JPopupMenu popupMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//这个是使用当前窗体的菜单栏作为整个程序的菜单栏
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		//设定当前的程序在屏幕最左上方苹果键右边的名称，直接设定的时候有可能不生效
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "MyApplicationTest");
		
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
		//对面板添加鼠标事件，增加弹出菜单
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//其中show有三种方法，使用第三种，传入父类，以及点击时的X坐标和Y坐标
				popupMenu.show(MyFrame.this, e.getX(), e.getY());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(MyFrame.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		
		mnFile.add(mntmOpen);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmClose.setIcon(new ImageIcon(MyFrame.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		mnFile.add(mntmClose);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnFile.add(mntmSearch);
		
		JMenu mnNewMenu = new JMenu("New Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnNewMenu.add(mntmUndo);
		
		JMenu mnStyle = new JMenu("Style");
		mnNewMenu.add(mnStyle);
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mnStyle.add(mntmRed);
		
		JMenuItem mntmBlue = new JMenuItem("Blue");
		mnStyle.add(mntmBlue);
		
		JMenuItem mntmGreen = new JMenuItem("Green");
		mnStyle.add(mntmGreen);
		
		//添加分割线
		mnNewMenu.addSeparator();
		
		final JCheckBoxMenuItem chckbxmntmA = new JCheckBoxMenuItem("a");
		mnNewMenu.add(chckbxmntmA);
		chckbxmntmA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(chckbxmntmA.getState());
			}
		});
		JCheckBoxMenuItem chckbxmntmB = new JCheckBoxMenuItem("b");
		mnNewMenu.add(chckbxmntmB);
		
		JCheckBoxMenuItem chckbxmntmC = new JCheckBoxMenuItem("c");
		mnNewMenu.add(chckbxmntmC);
		
		//添加分割线
		mnNewMenu.addSeparator();
		
		JRadioButtonMenuItem rdbtnmntmT = new JRadioButtonMenuItem("T1");
		mnNewMenu.add(rdbtnmntmT);
		
		JRadioButtonMenuItem rdbtnmntmT_1 = new JRadioButtonMenuItem("T2");
		mnNewMenu.add(rdbtnmntmT_1);
		
		
		
		//-----------弹出式菜单------------
		popupMenu = new JPopupMenu();
		
		JMenuItem item1 = new JMenuItem("A");
		JMenuItem item2 = new JMenuItem("B");
		JMenuItem item3 = new JMenuItem("C");
		JMenuItem item4 = new JMenuItem("D");
		JMenuItem item5 = new JMenuItem("E");
		
		popupMenu.add(item1);
		popupMenu.add(item2);
		
		//同时也可以添加分割线
		popupMenu.addSeparator();
		
		//为弹出式菜单添加
		JMenu menu = new JMenu("Other");
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		
		popupMenu.add(menu);
	}

}
