package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Add {

	private JFrame frame;
	private JLabel label_5;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
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
		
		JLabel label = new JLabel("鐠愶箑褰�");
		label.setBounds(119, 39, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("鐎靛棛鐖�");
		label_1.setBounds(119, 64, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("绾喛顓荤�靛棛鐖�");
		label_2.setBounds(119, 89, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		label_3.setBounds(119, 114, 54, 15);
		panel.add(label_3);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(119, 139, 54, 15);
		panel.add(lblId);
		
		JLabel label_4 = new JLabel("\u90E8\u95E8");
		label_4.setBounds(119, 164, 54, 15);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(227, 136, 83, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(227, 61, 83, 21);
		panel.add(passwordField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(227, 111, 83, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 161, 83, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		label_5 = new JLabel("\u65B0\u589E\u8D26\u53F7");
		label_5.setBounds(173, 10, 54, 15);
		panel.add(label_5);
		
		String[] identify = {"闂勩垽鏆�","閸栬崵鏁�","閺�鎯板瀭娴滃搫鎲�","缁狅紕鎮婇崨锟�","閼筋垰绗�"};
		JComboBox comboBox = new JComboBox(identify);
		comboBox.setSelectedIndex(4);
		

		comboBox.setBounds(227, 192, 83, 21);
		panel.add(comboBox);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD");
		label_6.setBounds(119, 195, 54, 15);
		panel.add(label_6);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBounds(100, 228, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(268, 228, 93, 23);
		panel.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 36, 83, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 86, 83, 21);
		panel.add(passwordField);
	}
}
