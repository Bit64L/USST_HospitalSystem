package outpatient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("收费人员登录");
		lblNewLabel.setBounds(160, 0, 82, 41);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(195, 56, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("密码");
		label.setBounds(143, 98, 54, 15);
		panel.add(label);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setBounds(131, 137, 70, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("账号");
		label_1.setBounds(143, 59, 54, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 95, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(223, 137, 70, 23);
		panel.add(button_1);
	}
}
