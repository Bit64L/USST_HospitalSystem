package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import staff.OrderInformation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JTextField textField;
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
		
		JLabel label = new JLabel("挂号");
		label.setBounds(166, 21, 54, 15);
		panel.add(label);
		
		JLabel lblid = new JLabel("病人ID");
		lblid.setBounds(98, 75, 54, 15);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(206, 72, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration reg=new Registration();
				OrderInformation orderInfor=new OrderInformation();
				orderInfor=reg.sendregister(textField.getText().toString());
				if(orderInfor!=null){
					Appointment ap=new Appointment(orderInfor);
					ap.setVisible(true);
				}
				else{
					NoAppointment na=new NoAppointment(textField.getText().toString());
					na.setVisible(true);
				}
			}
		});
		button.setBounds(109, 165, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(249, 165, 93, 23);
		panel.add(button_1);
	}

}
