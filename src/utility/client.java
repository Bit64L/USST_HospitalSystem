package utility;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class client {

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
					client window = new client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void login(){
		Socket socket=null;
		String ip="192.168.0.103";//服务器ip
		try {
			socket=new Socket(ip,8888);
			if(socket!=null){
				System.out.println("连接成功");
				String send="lg";
				String name=textField.getText().trim();
				String password=textField_1.getText();
				send=send+name+":"+password+"\n";
				PrintWriter os=new PrintWriter(socket.getOutputStream());
				os.write(send);
				os.flush();
				
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				String loginStatus=br.readLine();
				System.out.println(loginStatus);
				if(loginStatus.equals("success")){
					JOptionPane.showConfirmDialog(null, "登录成功", "登录", JOptionPane.DEFAULT_OPTION);
				}else{
					JOptionPane.showConfirmDialog(null, "用户名或密码错误", "登录", JOptionPane.DEFAULT_OPTION);
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the application.
	 */
	public client() {
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
		
		textField = new JTextField();
		textField.setBounds(185, 46, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 98, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setBounds(173, 148, 93, 23);
		panel.add(btnLogin);
		
		JLabel lblAccount = new JLabel("account");
		lblAccount.setBounds(103, 49, 54, 15);
		panel.add(lblAccount);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(103, 101, 54, 15);
		panel.add(lblPassword);
	}
}
