package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;

public class Welcome {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
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
		
		JLabel label = new JLabel("��ӭʹ������ϵͳ");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("\u8D26\u53F7");
		label_2.setBounds(145, 94, 54, 15);
		panel_1.add(label_2);
		
		label_3 = new JLabel("\u5BC6\u7801");
		label_3.setBounds(145, 143, 156, 15);
		panel_1.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(181, 91, 120, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(181, 186, 93, 23);
		panel_1.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 140, 120, 21);
		panel_1.add(passwordField);
		
		String[] identify = {"ҽ��","�շ���Ա","����Ա","ҩʦ","Ժ��"};
		JComboBox comboBox = new JComboBox(identify);
		comboBox.setSelectedIndex(4);
		
		comboBox.setBounds(181, 41, 120, 21);
		panel_1.add(comboBox);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD");
		label_1.setBounds(145, 44, 54, 15);
		panel_1.add(label_1);
	}
}
