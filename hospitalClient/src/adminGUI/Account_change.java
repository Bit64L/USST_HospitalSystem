package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Account_change extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private Administrator admin;
	private String id;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_change frame = new Account_change(new Administrator("",""), "000");
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
	public Account_change(Administrator admin,String id) {
		this.admin=admin;
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String name=textField_1.getText();
				changeInfo(id,password,name);
				dispose();
			}
		});
		button.setBounds(109, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(245, 218, 93, 23);
		panel.add(button_1);
		
		JLabel label_3 = new JLabel("修改账号");
		label_3.setBounds(166, 10, 54, 15);
		panel.add(label_3);
	}
	//修改信息
	public void changeInfo(String id,String password,String name){
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		try{
			s=new Socket("127.0.0.1",8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0014");
			out.writeObject(id+" "+password+" "+name);
			out.writeObject(admin);
			out.flush();
		}catch(Exception e){
			
		}
	}
	
}
