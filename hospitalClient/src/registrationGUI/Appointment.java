package registrationGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Doctor;
import person.Patient;
import staff.HospitalDepartment;
import staff.OrderInformation;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Appointment extends JFrame{
	//private OrderInformation orderInfor;
	private JPanel contentPane;
	private JTextField patientName;
	private JTextField patientAge;
	private JTextField patientPhoneNumber;
	private JTextField hospitalDepartmentName;
	private JTextField ordertime;
	private JTextField patientSex;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Appointment window = new Appointment();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Appointment(OrderInformation orderInfor) {
		setAlwaysOnTop(true);
		initialize(orderInfor);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(OrderInformation orderInfor) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		OrderInformation or=new OrderInformation();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel label = new JLabel("该病人已预约!");
		label.setBounds(161, 24, 112, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setBounds(118, 45, 54, 15);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("年龄:");
		label_3.setBounds(118, 95, 54, 15);
		panel.add(label_3);
		
		JLabel label_5 = new JLabel("科室:");
		label_5.setBounds(118, 145, 54, 15);
		panel.add(label_5);
		
		JLabel label_7 = new JLabel("预约时间:");
		label_7.setBounds(118, 170, 54, 15);
		panel.add(label_7);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientId=orderInfor.getPatientID();
				//String departmentName=comboBox.getSelectedItem().toString();
				//Doctor doctor=new Doctor("111","111","李达",new HospitalDepartment("内科","000001"));//方法,根据医生姓名,获取完整医生信息
				//Registration reg=new Registration();			
				
				Patient patient=new Patient();
				//将病人的 姓名 性别 年龄 联系电话 身份证号 预约时间录入到病人信息中
				patient.insertPatientInformation(patientName.getText().toString(),patientSex.getText().toString(),patientAge.getText().toString(),patientPhoneNumber.getText().toString(),patientId,ordertime.getText().toString());
				
				Registration reg=new Registration();
				Patient inPatient=reg.sendAddDoctorAppointmentdPatient(patient);
				//跳转到显示挂号信息界面
				RegistrationInformation ri=new RegistrationInformation(inPatient);
				ri.setVisible(true);
				
			}
		});
		button.setBounds(118, 207, 93, 23);
		panel.add(button);
		
		JLabel label_11 = new JLabel("联系方式:");
		label_11.setBounds(118, 120, 54, 15);
		panel.add(label_11);
		
		JButton button_1 = new JButton("编辑");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			patientName.setEditable(true);
			patientSex.setEditable(true);
			patientAge.setEditable(true);
			patientPhoneNumber.setEditable(true);
			hospitalDepartmentName.setVisible(false);//hospitalDepartmentName.setEditable(true);
			ordertime.setEditable(true);
			
			}
		});
		button_1.setBounds(221, 207, 93, 23);
		panel.add(button_1);
		
		patientName = new JTextField(orderInfor.getPatientName());
		patientName.setEditable(false);
		patientName.setBounds(175, 45, 100, 21);
		panel.add(patientName);
		patientName.setColumns(10);
		
		patientAge = new JTextField(orderInfor.getPatientAge());
		patientAge.setEditable(false);
		patientAge.setBounds(175, 95, 100, 21);
		panel.add(patientAge);
		patientAge.setColumns(10);
		
		patientPhoneNumber = new JTextField(orderInfor.getPatientPhoneNumber());
		patientPhoneNumber.setEditable(false);
		patientPhoneNumber.setBounds(175, 120, 100, 21);
		panel.add(patientPhoneNumber);
		patientPhoneNumber.setColumns(10);
		
		hospitalDepartmentName = new JTextField(orderInfor.getHospitalDepartment().getName());
		hospitalDepartmentName.setEditable(false);
		hospitalDepartmentName.setBounds(175, 145, 100, 21);
		panel.add(hospitalDepartmentName);
		hospitalDepartmentName.setColumns(10);
		
		ordertime = new JTextField(orderInfor.getMonth()+"/"+orderInfor.getDate()+"/"+orderInfor.getHour());
		ordertime.setEditable(false);
		ordertime.setBounds(175, 170, 100, 21);
		panel.add(ordertime);
		ordertime.setColumns(10);
		
		JLabel label_2 = new JLabel("性别:");
		label_2.setBounds(118, 70, 54, 15);
		panel.add(label_2);
		
		patientSex = new JTextField(orderInfor.getPatientSex());
		patientSex.setEditable(false);
		patientSex.setBounds(175, 70, 100, 21);
		panel.add(patientSex);
		patientSex.setColumns(10);
		
		JButton button_2 = new JButton("完成");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patientName.setEditable(false);
				patientSex.setEditable(false);
				patientAge.setEditable(false);
				patientPhoneNumber.setEditable(false);
				hospitalDepartmentName.setVisible(true);//hospitalDepartmentName.setEditable(true);

				ordertime.setEditable(false);

			}
		});
		button_2.setBounds(221, 207, 93, 23);
		panel.add(button_2);
	}
}
