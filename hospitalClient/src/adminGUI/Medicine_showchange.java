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

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Medicine_showchange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_showchange frame = new Medicine_showchange(new Administrator("a","a"));
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
	public Medicine_showchange(Administrator admin) {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 393, 154);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		//textArea.setText("显示药品信息");
		scrollPane.setViewportView(textArea);
		/*********显示账户信息*************/
		String accountsInfo=showAll();
		String[] strs=accountsInfo.split("\\$");
		for(int i=0;i<strs.length;i++){
			textArea.append(strs[i]+"\n");
		}
		/*******************************/
		JLabel label = new JLabel("输入要修改的药品编号");
		label.setBounds(43, 184, 130, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(228, 181, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Medicine_change medicine_change=new Medicine_change(admin,textField.getText());
				medicine_change.setVisible(true);
			}
		});
		button.setBounds(225, 218, 93, 23);
		panel.add(button);
	}
	public String showAll(){//显示所有信息
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		String info=null;
		try {
			s=new Socket("127.0.0.1",8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0024");
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
}
