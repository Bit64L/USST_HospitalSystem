package doctor_chargeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Doctor;
import staff.ChargeItem;
import staff.Medicine;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Doctor_Result extends JFrame {

	private JPanel contentPane;
	private Doctor doctor;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Doctor_Result(Doctor doctor) {
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 404, 142);
		panel.add(scrollPane);

		textArea = new JTextArea();
		textArea.setText("显示收费项目 和 药品");
		scrollPane.setViewportView(textArea);

		JLabel label = new JLabel("总金额");
		label.setBounds(10, 180, 54, 15);
		panel.add(label);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket s=null;
				ObjectInputStream in = null;
				ObjectOutputStream out =null;
				try{
					s=new Socket("127.0.0.1",8888);
					out=new ObjectOutputStream(s.getOutputStream());
					out.writeObject("0028");
					out.writeObject(doctor);
					out.flush();
				}catch(Exception ee){
					
				}
			}
		});
		button.setBounds(280, 207, 93, 23);
		panel.add(button);

		textField = new JTextField();
		textField.setText("总金额");
		textField.setBounds(80, 175, 54, 24);
		panel.add(textField);
		textField.setColumns(10);
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	// 更新医生对象
	public void updateDoctor(Doctor doctor) {
		Socket s = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			s = new Socket("127.0.0.1", 8888);
			out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject("0027");
			out.flush();
			in = new ObjectInputStream(s.getInputStream());
			Doctor newDoctor = (Doctor) in.readObject();
			setDoctor(newDoctor);
		} catch (Exception ee) {

		}
	}
	//显示药品和收费项目并显示总金额
	public void showInfo(){
		double amount=0;
		for(ChargeItem a:doctor.getPatients().get(0).getChargeItems()){
			textArea.append(a.getName()+" "+"x"+a.getNumber()+"\n");
			amount+=a.getAmount();
		}
		for(Medicine a:doctor.getPatients().get(0).getMedicines()){
			textArea.append(a.getName()+" "+a.getNumber()+"\n");
			amount+=a.getAmount();
		}
		textField.setText(String.valueOf(amount));
	}
}
