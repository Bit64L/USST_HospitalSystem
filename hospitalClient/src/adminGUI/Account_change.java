package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Account_change extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Administrator admin;

	/**
	 * Create the frame.
	 */
	public Account_change(Administrator admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(85, 31, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(232, 28, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(85, 69, 54, 15);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 66, 66, 21);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("真实姓名");
		label_2.setBounds(85, 113, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 110, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(85, 153, 54, 15);
		panel.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(232, 150, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("修改");
		button.setBounds(109, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(245, 218, 93, 23);
		panel.add(button_1);
		
		JLabel label_3 = new JLabel("修改账号");
		label_3.setBounds(166, 10, 54, 15);
		panel.add(label_3);
	}
}
