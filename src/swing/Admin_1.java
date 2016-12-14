package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_1 window = new Admin_1();
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
	public Admin_1() {
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
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton button = new JButton("\u7CFB\u7EDF\u8D26\u53F7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(31, 52, 165, 46);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u79D1\u5BA4\u4FE1\u606F");
		button_1.setBounds(237, 52, 154, 46);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u836F\u54C1\u4FE1\u606F");
		button_2.setBounds(31, 141, 165, 46);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u9879\u76EE\u6536\u8D39\u4FE1\u606F");
		button_3.setBounds(237, 141, 154, 46);
		panel_1.add(button_3);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u53EF\u4EE5\u589E\u5220\u6539\u4EE5\u4E0B\u4FE1\u606F");
		label_1.setBounds(270, 0, 154, 30);
		panel_1.add(label_1);
	}

}
