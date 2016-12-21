package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import person.Administrator;

public class Account_delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Administrator admin;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_delete frame = new Account_delete(new Administrator("",""));
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
	public Account_delete(Administrator admin) {
		this.admin=admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		
		JLabel lblid = new JLabel("请输入要删除的账户的用户名:");
		lblid.setBounds(19, 187, 209, 15);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(242, 183, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAccount(textField.getText());
			}
		});
		button.setBounds(78, 211, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(252, 211, 93, 23);
		panel.add(button_1);
		/*********显示账户信息*************/
		String accountsInfo=showAccounts();
		String[] strs=accountsInfo.split("\\$");
		for(int i=0;i<strs.length;i++){
			textArea.append(strs[i]+"\n");
		}
		/*******************************/
	}
	public String showAccounts(){//显示所有账号信息
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		String info=null;
		try {
			s=new Socket("127.0.0.1",8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0011");
			out.flush();
			in=new ObjectInputStream(s.getInputStream());
			info=(String)in.readObject();//账户信息之间用$隔开
			s.close();
			in.close();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return info;
	}
	public void deleteAccount(String userName){//删除账号
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		try {
			s=new Socket("127.0.0.1",8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0012");//发送协议
			out.writeObject(userName);//发送用户名
			out.writeObject(admin);//发送对象
			out.flush();
			s.close();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
