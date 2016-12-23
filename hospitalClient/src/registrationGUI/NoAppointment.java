package registrationGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import person.Patient;
import staff.HospitalDepartment;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoAppointment extends JFrame{

	private JPanel contentPane;
	private JTextField patientPhoneNumber;
	private JTextField patientAge;
	private JTextField patientName;
	private JTextField patientSex;
	private JTextField hospitalDepartmentName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NoAppointment window = new NoAppointment();
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
	public NoAppointment(String patinetId) {
		initialize(patinetId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String patinetId) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("录入挂号信息");
		label.setBounds(160, 23, 79, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setBounds(135, 45, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("年龄:");
		label_2.setBounds(135, 95, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("联系方式:");
		label_3.setBounds(135, 120, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("科室:");
		label_4.setBounds(135, 145, 54, 15);
		panel.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"内科", "牙科", "小儿科", "外科"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(323, 152, 91, 21);
		panel.add(comboBox);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patient patient=new Patient();
				patient.setId(patinetId);
				patient.setName(patientName.getText());
				patient.setAge(patientAge.getText());
				patient.setSex(patientSex.getText());
				patient.setHospitalDepartment(new HospitalDepartment(comboBox.getSelectedItem().toString()));
				Registration reg=new Registration();
				Patient inPatient=reg.sendAddDoctorNoAppointmentdPatient(patient);
				//跳转到显示挂号信息界面
				
				
			}
		});
		button.setBounds(149, 194, 93, 23);
		panel.add(button);
		
		patientPhoneNumber = new JTextField();
		patientPhoneNumber.setText("phonenumber");
		patientPhoneNumber.setBounds(200, 120, 100, 21);
		panel.add(patientPhoneNumber);
		patientPhoneNumber.setColumns(10);
		
		patientAge = new JTextField("age");
		patientAge.setBounds(200, 95, 100, 21);
		panel.add(patientAge);
		patientAge.setColumns(10);
		
		patientName = new JTextField();
		patientName.setText("name");
		patientName.setBounds(200, 45, 100, 21);
		panel.add(patientName);
		patientName.setColumns(10);
		
		JLabel label_5 = new JLabel("性别:");
		label_5.setBounds(135, 70, 54, 15);
		panel.add(label_5);
		
		patientSex = new JTextField();
		patientSex.setText("sex");
		patientSex.setBounds(200, 70, 100, 21);
		panel.add(patientSex);
		patientSex.setColumns(10);
		
		hospitalDepartmentName = new JTextField();
		hospitalDepartmentName.setText("hospitalDepartmentName");
		hospitalDepartmentName.setBounds(200, 145, 100, 21);
		panel.add(hospitalDepartmentName);
		hospitalDepartmentName.setColumns(10);
	}
}
