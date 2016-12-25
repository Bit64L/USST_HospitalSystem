package order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import utility.Time;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.DefaultComboBoxModel;

public class orderGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String hospitalDepartmentNames;//获取科室信息,字符串
	private String[] hdNames;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderGUI window = new orderGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public orderGUI() {
		initialize();
		
	}
	public String getHospitalDepartmentInformation(){
		// TODO Auto-generated method stub
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
		
		try {
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			inobj=new ObjectInputStream(socket.getInputStream());

			outobj.writeObject("预约要科室信息");
			outobj.flush();
			try {
				hospitalDepartmentNames=(String) inobj.readObject();
				return hospitalDepartmentNames;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return null;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		hospitalDepartmentNames=getHospitalDepartmentInformation();
		hdNames=hospitalDepartmentNames.split(":");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(180, 10, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 41, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 72, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 103, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 134, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("身份证号");
		lblNewLabel.setBounds(101, 13, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(116, 44, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(116, 75, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(116, 106, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("电话号码");
		label_3.setBounds(101, 137, 54, 15);
		panel.add(label_3);
		
		JButton btnNewButton = new JButton("预约");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String patientID=textField.getText();
				String name=textField_1.getText();
				String sex=textField_2.getText();
				int age=Integer.parseInt(textField_3.getText());
				String phoneNumber=textField_4.getText();
				int hospitalDepartmentID=1;
				String hospitalDepartmentName="妇科";
				String orderTime=new Time().getCurrentTime();
				Order newOrder=new Order(patientID, name, sex, age, phoneNumber, hospitalDepartmentID, hospitalDepartmentName, orderTime);
				newOrder.wanttoorder(newOrder);
			}
		});
		btnNewButton.setBounds(166, 203, 93, 23);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(hdNames));
		comboBox.setBounds(180, 165, 32, 21);
		panel.add(comboBox);
	}
}
