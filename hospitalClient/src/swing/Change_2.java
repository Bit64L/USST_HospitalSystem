package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Change_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_2 window = new Change_2();
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
	public Change_2() {
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
		
		JLabel label = new JLabel("账号");
		label.setBounds(99, 27, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(220, 24, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(99, 52, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("确认密码");
		label_2.setBounds(99, 77, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("真实姓名");
		label_3.setBounds(99, 102, 54, 15);
		panel.add(label_3);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(99, 127, 54, 15);
		panel.add(lblId);
		
		JLabel label_4 = new JLabel("部门");
		label_4.setBounds(99, 152, 54, 15);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 149, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 124, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(220, 99, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 74, 66, 21);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(220, 49, 66, 21);
		panel.add(passwordField_1);
		
		JButton button = new JButton("确定");
		button.setBounds(95, 208, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(236, 208, 93, 23);
		panel.add(button_1);
	}

}
