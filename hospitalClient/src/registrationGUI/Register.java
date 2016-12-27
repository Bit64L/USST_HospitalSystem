package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Patient;
import staff.OrderInformation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JTextField patientId;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("病人ID");
		lblid.setBounds(98, 75, 54, 15);
		panel.add(lblid);
		
		patientId = new JTextField();
		patientId.setBounds(175, 72, 150, 21);
		panel.add(patientId);
		patientId.setColumns(10);
		
		JButton button = new JButton("挂号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration reg=new Registration();
				OrderInformation orderInfor=new OrderInformation();
				orderInfor=reg.sendregister(patientId.getText().toString());
				if(orderInfor!=null){
					Appointment ap=new Appointment(orderInfor);
					ap.setVisible(true);
				}
				else{
					NoAppointment na=new NoAppointment(patientId.getText().toString());
					na.setVisible(true);
				}
			}
		});
		button.setBounds(109, 165, 93, 23);
		panel.add(button);
		
		JButton btnNewButton = new JButton("收费");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration reg=new Registration();
				Patient patient=reg.sendPatientChargeItem(patientId.getText().toString());
				if(patient!=null){
					Charge ch=new Charge(patient);
					ch.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "该病人未挂号"); 
			}
		});
		btnNewButton.setBounds(224, 165, 93, 23);
		panel.add(btnNewButton);
	}
}
