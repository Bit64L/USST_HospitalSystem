package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Item_change extends JFrame {

	private JPanel contentPane;
	private JTextField txtc;
	private JTextField txtc_1;
	private JTextField txtc_2;
	private JTextField txtc_3;
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
					Item_change frame = new Item_change(new Administrator("",""),"123");
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
	public Item_change(Administrator admin,String str) {
		this.str=str;
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
		
		JLabel label = new JLabel("修改收费项目");
		label.setBounds(166, 10, 83, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("收费项目名称");
		label_1.setBounds(55, 43, 118, 15);
		panel.add(label_1);
		
		txtc = new JTextField();
		txtc.setBounds(224, 40, 66, 21);
		panel.add(txtc);
		txtc.setColumns(10);
		
		JLabel label_2 = new JLabel("收费项目简称");
		label_2.setBounds(55, 82, 107, 15);
		panel.add(label_2);
		
		txtc_1 = new JTextField();
		txtc_1.setBounds(224, 79, 66, 21);
		panel.add(txtc_1);
		txtc_1.setColumns(10);
		
		JLabel label_3 = new JLabel("收费项目单位");
		label_3.setBounds(55, 118, 117, 15);
		panel.add(label_3);
		
		txtc_2 = new JTextField();
		txtc_2.setBounds(224, 115, 66, 21);
		panel.add(txtc_2);
		txtc_2.setColumns(10);
		
		JLabel label_4 = new JLabel("收费项目单价");
		label_4.setBounds(55, 154, 107, 15);
		panel.add(label_4);
		
		txtc_3 = new JTextField();
		txtc_3.setBounds(224, 151, 66, 21);
		panel.add(txtc_3);
		txtc_3.setColumns(10);
		
		
		JButton button = new JButton("确认修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String name=txtc.getText();
				String shortName=txtc_1.getText();
				String Unit=txtc_2.getText();
				String Price=txtc_3.getText();
				changeInfo(str,name,shortName,Unit,Price);
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
	//修改信息
		public void changeInfo(String No,String name,String shortName,String newUnit,String newPrice){
			Socket s=null;
			ObjectInputStream in=null;
			ObjectOutputStream out=null;
			try{
				s=new Socket("127.0.0.1",8888);
				out=new ObjectOutputStream(s.getOutputStream());
				out.writeObject("0016");
				out.writeObject(No+" "+name+" "+shortName+" "+newUnit+" "+newPrice);
				out.writeObject(admin);
				out.flush();
			}catch(Exception e){
				
			}
		}	
}
