package doctor_chargeGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import person.Doctor;

public class Doctor_Charge extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Doctor doctor;


	/**
	 * Create the frame.
	 */
	public Doctor_Charge(Doctor doctor) {
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
		
		JLabel label = new JLabel("输入简称");
		label.setBounds(10, 40, 77, 15);
		panel.add(label);
		
		textField = new JTextField("简称");
		textField.setBounds(76, 36, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("数量");
		label_2.setBounds(154, 40, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField("数量");
		textField_1.setBounds(205, 36, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("添加");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jc=textField.getText();
				String number=textField_1.getText();
				Socket s=null;
				ObjectInputStream in = null;
				ObjectOutputStream out =null;
				try{
					s=new Socket("127.0.0.1",8888);
					out=new ObjectOutputStream(s.getOutputStream());
					out.writeObject("0025");
					out.writeObject(jc);
					out.flush();
					/********///发送来药品或检查项目
					
					
					
					
				}catch(Exception ee){
					
				}
			}
		});
		button_1.setBounds(295, 35, 93, 23);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 404, 91);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("药品信息");
		scrollPane.setViewportView(textArea);
		
		JButton button_2 = new JButton("生成报告");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame frame = new Doctor_Result(doctor);
				frame.setVisible(true);
			}
		});
		button_2.setBounds(277, 203, 93, 23);
		panel.add(button_2);
	}
}
