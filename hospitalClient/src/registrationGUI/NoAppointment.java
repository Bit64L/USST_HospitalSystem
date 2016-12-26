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
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
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

public class NoAppointment extends JFrame {

	private JPanel contentPane;
	private JTextField patientPhoneNumber;
	private JTextField patientAge;
	private JTextField patientName;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private ButtonGroup btnGroup;
	private JComboBox comboBox;
	private String[] hdNames;
	private String hospitalDepartmentNames;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// NoAppointment window = new NoAppointment();
	// window.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

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
		label_1.setBounds(135, 48, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("年龄:");
		label_2.setBounds(135, 98, 54, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("联系方式:");
		label_3.setBounds(135, 123, 54, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("科室:");
		label_4.setBounds(135, 148, 54, 15);
		panel.add(label_4);

		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patient patient = new Patient();

				String sex = "";
				if (rdbtnNewRadioButton.isSelected()) {
					sex = "男";
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					sex = "女";
				}

				patient.setId(patinetId);
				patient.setName(patientName.getText());
				patient.setAge(patientAge.getText());
				patient.setSex(sex);
				patient.setPhoneNumber(patientPhoneNumber.getText().toString());
				patient.setHospitalDepartment(new HospitalDepartment(comboBox.getSelectedItem().toString()));
				Registration reg = new Registration();
				Patient inPatient = reg.sendAddDoctorNoAppointmentdPatient(patient);
				if (inPatient != null) {
					// 跳转到显示挂号信息界面
					RegistrationInformation ri = new RegistrationInformation(inPatient);
					ri.setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "当前科室暂无医生就诊");
				dispose();

			}
		});
		button.setBounds(149, 194, 93, 23);
		panel.add(button);

		patientPhoneNumber = new JTextField();
		patientPhoneNumber.setText("phonenumber");
		patientPhoneNumber.setBounds(200, 120, 140, 21);
		panel.add(patientPhoneNumber);
		patientPhoneNumber.setColumns(10);

		patientAge = new JTextField("age");
		patientAge.setBounds(200, 95, 140, 21);
		panel.add(patientAge);
		patientAge.setColumns(10);

		patientName = new JTextField();
		patientName.setText("name");
		patientName.setBounds(200, 45, 140, 21);
		panel.add(patientName);
		patientName.setColumns(10);

		JLabel label_5 = new JLabel("性别:");
		label_5.setBounds(135, 73, 54, 15);
		panel.add(label_5);

		rdbtnNewRadioButton = new JRadioButton("男", true);
		rdbtnNewRadioButton.setBounds(200, 70, 57, 23);
		panel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(280, 70, 48, 23);
		panel.add(rdbtnNewRadioButton_1);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnNewRadioButton);
		btnGroup.add(rdbtnNewRadioButton_1);

		Registration reg = new Registration();
		hospitalDepartmentNames = reg.getHospitalDepartmentInformation();
		hdNames = hospitalDepartmentNames.split(":");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(hdNames));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(199, 145, 68, 21);
		panel.add(comboBox);
	}
}
