package TestComponent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

//JProgressBar进度条
public class TestJProgressBar extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJProgressBar frame = new TestJProgressBar();
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
	public TestJProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.SOUTH);
		
		JButton btnRun = new JButton("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SwingWorker<String, Integer>() {

					@Override
					protected String doInBackground() throws Exception {
						for(int i =0; i <= 10; i++) {
							Thread.sleep(1000);
							publish(i * 10);
						}
						return null;
					}

					@Override
					protected void process(List<Integer> chunks) {
						for(Integer integer: chunks) {
							progressBar.setValue(integer);
						}
					}
					
					
					
				}.execute();
			}
		});
		contentPane.add(btnRun, BorderLayout.NORTH);
	}

}
