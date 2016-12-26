package doctor_chargeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import data.Data;
import person.Doctor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Doctor_patientinfo extends JFrame {

	private JPanel contentPane;
	private Doctor doctor;
	private JTextArea textArea;
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Doctor_patientinfo(Doctor doctor) {
		updateDoctor(doctor);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		showInfo();//显示病人信息
		JButton button = new JButton("开处方");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor_Charge frame=new Doctor_Charge(doctor);
				frame.setVisible(true);
			}
		});
		button.setBounds(95, 200, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(263, 200, 93, 23);
		panel.add(button_1);
	}
	public void showInfo(){
		textArea.append(doctor.getPatients().get(0).getName()+"\t"
				+doctor.getPatients().get(0).getId()+"\t"
				+doctor.getPatients().get(0).getSex()+"\t"+doctor.getPatients().get(0).getPhoneNumber()
			);
	}	
	// 更新医生对象
		public void updateDoctor(Doctor doctor) {
			Socket s = null;
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			try {
				s = new Socket(Data.IP, 8888);
				out = new ObjectOutputStream(s.getOutputStream());
				out.writeObject("0027");
				out.writeObject(doctor);
				out.flush();
				in = new ObjectInputStream(s.getInputStream());
				Doctor newDoctor = (Doctor) in.readObject();
				setDoctor(newDoctor);
			} catch (Exception ee) {

			}
		}
		
}
