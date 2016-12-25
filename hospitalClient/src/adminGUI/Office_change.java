package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Office_change extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Administrator admin;
	private String str;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_change frame = new Office_change(new Administrator("a","a")," ");
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
	public Office_change(Administrator admin,String str) {
		this.str=str;
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
		
		JLabel label = new JLabel("科室名称");
		label.setBounds(99, 49, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(228, 46, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确认修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String name=textField.getText();
				changeInfo(str,name);
			}
		});
		button.setBounds(99, 186, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(252, 186, 93, 23);
		panel.add(button_1);
	}
	public void changeInfo(String No,String name){
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		try{
			s=new Socket("127.0.0.1",8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0018");
			out.writeObject(No+" "+name);
			out.writeObject(admin);
			out.flush();
		}catch(Exception e){
			
		}
	}
}
