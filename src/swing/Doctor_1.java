package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class Doctor_1 {

	private JFrame frame;
	private JTextArea textArea;

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
		textArea.setText("���У�");
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		
		JButton button = new JButton("\u53EB\u53F7");
		button.setBounds(50, 201, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5237\u65B0\uFF1F");
		button_1.setBounds(176, 201, 93, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.setBounds(294, 201, 93, 23);
		panel.add(button_2);
	}

}
