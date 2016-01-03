package TestSwingThread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;

//测试SwingWorker
public class TestSwingWorker extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwingWorker frame = new TestSwingWorker();
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
	public TestSwingWorker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnRun = new JButton("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				webRead();
			}
		});
		contentPane.add(btnRun, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	
	public void webRead() {
		//非常方便的在当前的UI线程当中，执行耗时的操作,并且很安全的将返回值发送给UI线程
		//两个泛型，一个是执行结果的类型，第二个是中间发布的结果的类型
		new SwingWorker<StringBuilder, String>() {
			
			//必须重写的方法
			@Override
			protected StringBuilder doInBackground() throws Exception {
				//开启一个网络连接
				URL url = new URL("http://www.apache.org");
				URLConnection connection = url.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
				
				//用于读取每一行中的数据
				String line;
				StringBuilder builder = new StringBuilder();
				//如果不为空，就代表里面是存在内容的
				while(( line = reader.readLine() ) != null) {
					//该方法会将结果发布给process方法，这样发布的话每一行都会调用process方法
					//publish(line);
					//思路是先加入到StringBuilder中
					builder.append(line).append("\n");
				}
				reader.close();//将流关闭
				//return了的返回值会发送给SwingWorker中的done方法
				return builder;
			}

			//还可以覆盖它的done和process两个方法
			//process方法自动分发给UI线程，所以是线程安全的！
			@Override
			protected void process(List<String> chunks) {
				for(String line : chunks) {
					textArea.append(line);
					//同时换行
					textArea.append("\n");
				}
				super.process(chunks);
			}

			@Override
			protected void done() {
				// 接收doInBackground方法的返回值，使用get()方法
				try {
					textArea.setText(get().toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done();
			}
	
		}.execute();
	}
}
