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

public class Item_add extends JFrame {

	private JPanel contentPane;
	private JTextField txtc;
	private JTextField txtc_1;
	private JTextField txtc_2;
	private JTextField txtc_3;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item_add frame = new Item_add(new Administrator("",""));
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
	public Item_add(Administrator admin) {
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
		
		JLabel label = new JLabel("添加收费项目");
		label.setBounds(166, 10, 83, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("收费项目名称");
		label_1.setBounds(69, 43, 104, 15);
		panel.add(label_1);
		
		txtc = new JTextField();
		txtc.setBounds(224, 40, 66, 21);
		panel.add(txtc);
		txtc.setColumns(10);
		
		JLabel label_2 = new JLabel("收费项目简称");
		label_2.setBounds(69, 82, 93, 15);
		panel.add(label_2);
		
		txtc_1 = new JTextField();
		txtc_1.setBounds(224, 79, 66, 21);
		panel.add(txtc_1);
		txtc_1.setColumns(10);
		
		JLabel label_3 = new JLabel("收费项目单位");
		label_3.setBounds(69, 118, 103, 15);
		panel.add(label_3);
		
		txtc_2 = new JTextField();
		txtc_2.setBounds(224, 115, 66, 21);
		panel.add(txtc_2);
		txtc_2.setColumns(10);
		
		JLabel label_4 = new JLabel("收费项目单价");
		label_4.setBounds(69, 154, 93, 15);
		panel.add(label_4);
		
		txtc_3 = new JTextField();
		txtc_3.setBounds(224, 151, 66, 21);
		panel.add(txtc_3);
		txtc_3.setColumns(10);
		
		JButton button = new JButton("确认添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String name=txtc.getText();
				String shortName=txtc_1.getText();
				String unit=txtc_2.getText();
				String price=txtc_3.getText();
				//String no=textField.getText();
				Socket s=null;
				ObjectOutputStream out=null;
				ObjectInputStream in=null;
				try{
					s=new Socket("127.0.0.1",8888);
					out=new ObjectOutputStream(s.getOutputStream());
					
					String str="0015";
					out.writeObject(str);//发送协议
					str=name+" "+shortName+" "+unit+" "+price;
					out.writeObject(str);//发送数据
					out.writeObject(admin);//发送对象
					out.flush();
					s.close();
					in.close();
					out.close();
				}catch(Exception e1){
					
				}
			}
		});
		button.setBounds(121, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(248, 220, 93, 23);
		panel.add(button_1);
	}

}
