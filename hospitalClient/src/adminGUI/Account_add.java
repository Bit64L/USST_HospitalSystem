package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Account_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_add frame = new Account_add();
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
	public Account_add() {
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
		label.setBounds(74, 41, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(198, 38, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(74, 77, 54, 15);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 74, 66, 21);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("真实姓名");
		label_2.setBounds(74, 114, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 111, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(74, 155, 54, 15);
		panel.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 152, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("确认添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=textField.getText();
				String password=passwordField.getText();
				String name=textField_1.getText();
				String id=textField_2.getText();
				Socket s=null;
				Scanner in=null;
				PrintWriter out=null;
				try{
					s=new Socket("127.0.0.1",8888);
					in=new Scanner(s.getInputStream());
					out=new PrintWriter(s.getOutputStream());
					String str="0010"+" "+userName+" "+password+" "+name+" "+id;
					out.print(str);
					out.flush();
					s.close();
					in.close();
					out.close();
				}catch(IOException e1){
					
				}
			}
		});
		button.setBounds(92, 205, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(256, 205, 93, 23);
		panel.add(button_1);
		
		JLabel label_4 = new JLabel("添加系统账号");
		label_4.setBounds(162, 10, 93, 15);
		panel.add(label_4);
	}
}
