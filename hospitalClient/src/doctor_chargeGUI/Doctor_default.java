package doctor_chargeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import data.Data;
import person.Doctor;
import person.Patient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Doctor_default extends JFrame {

	private JPanel contentPane;
	Doctor doctor;
	private JTextArea textArea;


	/**
	 * Create the frame.
	 */
	
	public Doctor_default(Doctor doctor) {
		this.doctor=doctor;
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
		showPatients();//显示病人队列
		JButton button = new JButton("叫号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_patientinfo frame=new Doctor_patientinfo(doctor);
				frame.setVisible(true);
			}
		});
		button.setBounds(81, 200, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("更新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDoctor(doctor);
				textArea.setText("");
				showPatients();
			}
		});
		button_1.setBounds(253, 200, 93, 23);
		panel.add(button_1);
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	//显示病人队列
	public void showPatients(){
		for(Patient a:doctor.getPatients()){
			textArea.append(a.getName()+"\t"+a.getId()+'\n');
		}
	}
	//更新医生对象
	public void updateDoctor(Doctor doctor){
		Socket s=null;
		ObjectInputStream in = null;
		ObjectOutputStream out =null;
		try{
			s=new Socket(Data.IP,8888);
			out=new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0027");
			out.writeObject(doctor);
			out.flush();
			in=new ObjectInputStream(s.getInputStream());
			Doctor newDoctor=(Doctor)in.readObject();
			setDoctor(newDoctor);
			
		}catch(Exception ee){
			
		}
	}
}
