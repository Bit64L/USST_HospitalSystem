package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor_1 {

	private JFrame frame;
	private JTextArea textArea;
	protected String[] args;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_1 window = new Doctor_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Doctor_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		textArea.setText("显示队列情况");
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		
		JButton button = new JButton("叫号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_2.main(args);
				frame.setVisible(false);
			}
		});
		button.setBounds(50, 201, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("刷新");
		button_1.setBounds(176, 201, 93, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("返回");
		button_2.setBounds(294, 201, 93, 23);
		panel.add(button_2);
	}

}
