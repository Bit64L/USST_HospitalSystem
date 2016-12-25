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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class orderGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String hospitalDepartmentNames;//获取科室信息,字符串
	private String[] hdNames;
	private String orderTimeHour;
	JComboBox comboBox;
	JComboBox comboBox_1;
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
	public static String getCurrentDate(){ //获取当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String currentDate=sdf.format(date);
		return currentDate;
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
		textField.setBounds(206, 10, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 41, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 72, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 103, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 134, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("身份证号");
		lblNewLabel.setBounds(142, 13, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(152, 44, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(152, 75, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(152, 106, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("电话号码");
		label_3.setBounds(142, 137, 54, 15);
		panel.add(label_3);
		
		JButton btnNewButton = new JButton("预约");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patientID=textField.getText();
				String name=textField_1.getText();
				String sex=textField_2.getText();
				int age=Integer.parseInt(textField_3.getText());
				String phoneNumber=textField_4.getText();	
			    String hospitalDepartmentName = (String)comboBox.getSelectedItem();
			    String orderTime=getCurrentDate()+" "+comboBox_1.getSelectedItem();
				Order newOrder=new Order(patientID, name, sex, age, phoneNumber, hospitalDepartmentName, orderTime);
				newOrder.wanttoorder(newOrder);
			}
		});
		btnNewButton.setBounds(179, 227, 93, 23);
		panel.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(hdNames));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(206, 159, 66, 21);
		panel.add(comboBox);
		
		JLabel label_4 = new JLabel("选择科室");
		label_4.setBounds(142, 162, 54, 15);
		panel.add(label_4);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(206, 190, 66, 21);
		panel.add(comboBox_1);
		
		JLabel label_5 = new JLabel("预约明天");
		label_5.setBounds(142, 193, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("预约：");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 30));
		label_6.setBounds(27, -9, 110, 111);
		panel.add(label_6);
	}
}
