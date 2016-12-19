package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JTextField;

import function.Login;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;

public class Welcome {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	JComboBox comboBox;
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
		
		JLabel label = new JLabel("欢迎使用医院门诊工作流管理系统");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("账号");
		label_2.setBounds(145, 94, 54, 15);
		panel_1.add(label_2);
		
		label_3 = new JLabel("密码");
		label_3.setBounds(145, 143, 156, 15);
		panel_1.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(181, 91, 120, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName=textField.getText();
				String password=passwordField.getText();
				String type=comboBox.getSelectedItem().toString();
				boolean bool = new Login(userName,password,type).login();//登录
				if(bool==true) {
					System.out.println("登录成功");
					switch(type){
						case "管理员":
							Admin_1 admin_1=new Admin_1();
							admin_1.s
							break;
						case "医生":
							break;
						case "收费人员":
							break;
						case "院长":
							break;
						case "药师":
							break;
					}
				}
				else System.out.println("登录失败");
				
			}
		});
		button.setBounds(181, 186, 93, 23);
		panel_1.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 140, 120, 21);
		panel_1.add(passwordField);
		
		String[] identify = {"医生","收费人员","管理员","药师","院长"};
		comboBox = new JComboBox(identify);
		comboBox.setSelectedIndex(4);
		
		comboBox.setBounds(181, 41, 120, 21);
		panel_1.add(comboBox);
		
		JLabel label_1 = new JLabel("身份");
		label_1.setBounds(145, 44, 54, 15);
		panel_1.add(label_1);
	}
}
