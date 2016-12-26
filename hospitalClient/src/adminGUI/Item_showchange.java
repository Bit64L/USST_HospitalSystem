package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Data;
import person.Administrator;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Item_showchange extends JFrame {

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
					Item_showchange frame = new Item_showchange(new Administrator("",""));
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
	public Item_showchange(Administrator admin) {
		this.admin =admin;
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
		scrollPane.setBounds(10, 20, 404, 148);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		/*********显示账户信息*************/
		String accountsInfo=showChargeItem();
		String[] strs=accountsInfo.split("\\$");
		for(int i=0;i<strs.length;i++){
			textArea.append(strs[i]+"\n");
		}
		/*******************************/
		JLabel label = new JLabel("输入要修改的收费项目编号");
		label.setBounds(64, 191, 155, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(288, 188, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Item_change item_change=new Item_change(admin,textField.getText());
				item_change.setVisible(true);
			}
		});
		button.setBounds(192, 218, 93, 23);
		panel.add(button);
	}
	public String showChargeItem(){//显示所有收费信息
		Socket s=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		String info=null;
		try {
			s=new Socket(Data.IP,8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0023");
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
