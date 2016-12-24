package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Patient;

import javax.swing.JLabel;
import javax.swing.JButton;

public class RegistrationInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistrationInformation frame = new RegistrationInformation();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegistrationInformation(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("挂号信息");
		lblNewLabel.setBounds(182, 10, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setBounds(125, 45, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(125, 70, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("年龄");
		lblNewLabel_3.setBounds(125, 95, 54, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setBounds(125, 120, 54, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("联系电话:");
		lblNewLabel_5.setBounds(125, 145, 54, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("科室:");
		lblNewLabel_6.setBounds(125, 170, 54, 15);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("医生");
		lblNewLabel_7.setBounds(125, 195, 54, 15);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(patient.getName());
		lblNewLabel_8.setBounds(200, 45, 54, 15);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(patient.getSex());
		lblNewLabel_9.setBounds(200, 70, 54, 15);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(patient.getAge());
		lblNewLabel_10.setBounds(200, 95, 54, 15);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(patient.getId());
		lblNewLabel_11.setBounds(200, 120, 54, 15);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(patient.getPhoneNumber());
		lblNewLabel_12.setBounds(200, 145, 54, 15);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(patient.getHospitalDepartment().getName());
		lblNewLabel_13.setBounds(200, 170, 54, 15);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(patient.getDoctor().getName());
		lblNewLabel_14.setBounds(200, 195, 54, 15);
		panel.add(lblNewLabel_14);
		
		JButton button = new JButton("确定");
		button.setBounds(153, 218, 93, 23);
		panel.add(button);
	}
}
