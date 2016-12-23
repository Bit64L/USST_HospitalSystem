package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Charge_1 extends JFrame {

	private JPanel contentPane;
	private JTextField patientId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Charge_1 frame = new Charge_1();
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
	public Charge_1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("收费信息");
		label.setBounds(172, 10, 54, 15);
		panel.add(label);
		
		JLabel lblid = new JLabel("病人ID");
		lblid.setBounds(114, 62, 54, 15);
		panel.add(lblid);
		
		patientId = new JTextField();
		patientId.setBounds(229, 59, 66, 21);
		panel.add(patientId);
		patientId.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration reg=new Registration();
				Patient patient=reg.sendPatientChargeItem(patientId.getText().toString());
				if(patient!=null){
					Charge_2 ch=new Charge_2(patient);
					ch.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "无该用户收费信息"); 
			}
		});
		button.setBounds(152, 172, 93, 23);
		panel.add(button);
	}

}
