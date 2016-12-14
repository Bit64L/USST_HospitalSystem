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
		
		JLabel label = new JLabel("管理员");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton button = new JButton("账号信息 ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(31, 52, 165, 46);
		panel_1.add(button);
		
		JButton button_1 = new JButton("科室信息");
		button_1.setBounds(237, 52, 154, 46);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("药品信息");
		button_2.setBounds(31, 141, 165, 46);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("项目信息");
		button_3.setBounds(237, 141, 154, 46);
		panel_1.add(button_3);
		
		JLabel label_1 = new JLabel("管理员可以增删改以下信息");
		label_1.setBounds(270, 0, 154, 30);
		panel_1.add(label_1);
	}

}
