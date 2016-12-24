package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import person.Administrator;

public class Account_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private Administrator admin;
	JComboBox comboBox;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_add frame = new Account_add(new Administrator("",""));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Account_add(Administrator admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("用户名");
		label.setBounds(74, 80, 54, 15);
		//panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(198, 80, 66, 21);
		//panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(74, 111, 54, 15);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 108, 66, 21);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("真实姓名");
		label_2.setBounds(74, 139, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 136, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确认添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=textField.getText();
				String password=passwordField.getText();
				String name=textField_1.getText();
				String type=comboBox.getSelectedItem().toString();
				String hospitalDepartment=textField_2.getText();
				Socket s=null;
				ObjectOutputStream out=null;
				ObjectInputStream in=null;
				try{
					s=new Socket("127.0.0.1",8888);
					out=new ObjectOutputStream(s.getOutputStream());
					
					String str="0010";
					out.writeObject(str);//发送协议
					str=userName+" "+password+" "+name+" "+type+" "+hospitalDepartment;
					out.writeObject(str);//发送数据
					out.flush();
					
					in=new ObjectInputStream(s.getInputStream());
					in.readObject();//保持
					
					out.writeObject(admin);//发送对象
					out.flush();
					s.close();
					in.close();
					out.close();
				}catch(Exception e1){
					
				}
				dispose();
			}
		});
		button.setBounds(92, 205, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(256, 205, 93, 23);
		panel.add(button_1);
		
		String[] str  = {"管理员","医生","收费人员","药师","院长"};
		
		
		
		JLabel label_4 = new JLabel("添加系统账号");
		label_4.setBounds(92, 10, 93, 15);
		panel.add(label_4);
		
		comboBox = new JComboBox(str);
		comboBox.setBounds(198, 7, 93, 21);
		panel.add(comboBox);
		
		JLabel label_3 = new JLabel("科室");
		label_3.setBounds(74, 174, 72, 18);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setText("无");
		textField_2.setColumns(10);
		textField_2.setBounds(198, 171, 66, 21);
		panel.add(textField_2);
	}
}
