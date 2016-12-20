package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import function.Login;
import person.Administrator;public class Welcome extends JFrame{
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
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public  Welcome() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("欢迎使用医院门诊工作流管理系统");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
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
					//System.out.println("登录成功");
					switch(type){
						case "管理员":
							dispose();
							//Administrator administrator =;//获得服务器传送来的管理员对象
							JFrame default_=new Default();
							default_.setVisible(true);
							//System.out.println("登录成功");
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
