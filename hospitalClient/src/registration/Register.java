package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import person.Charger;
import person.Patient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField PatientID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("挂号");
		label.setBounds(166, 10, 54, 15);
		panel.add(label);
		
		JLabel lblid = new JLabel("病人ID");
		lblid.setBounds(113, 59, 54, 15);
		panel.add(lblid);
		
		PatientID = new JTextField();
		PatientID.setBounds(187, 56, 66, 21);
		panel.add(PatientID);
		PatientID.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Patient_ID=PatientID.getText().toString();
				//Patient pa=new Patient();
				//pa.setId(Patient_ID);
				//Charger ch=new Charger();
				boolean bool=true;//ch.findInOder(pa);
				//判断是否为预约病人
				if(bool){
					Appointment ap=new Appointment();
					JFrame AP=ap.getJFrame();
					AP.setVisible(true);
				}
				else{
					NoAppointment ap=new NoAppointment();
					JFrame NA=ap.getJFrame();
					NA.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(141, 99, 93, 23);
		panel.add(btnNewButton);
	}
	//获取JFrame窗口
	public JFrame getJFrame(){
		return frame;
	}
}
