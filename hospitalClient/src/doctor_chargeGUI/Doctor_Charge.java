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

import data.Data;
import staff.*;
import person.Doctor;
import javax.swing.SwingConstants;

public class Doctor_Charge extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField mnum;
	private Doctor doctor;
	private JTextField textField_2;
	private JTextField cnum;
	private JPanel panel;
	private JTextArea textArea;
	String results="";//处方单

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
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("药品简称");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 40, 88, 15);
		panel.add(label);
		
		textField = new JTextField("");
		textField.setBounds(112, 36, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lable2 = new JLabel("数量");
		lable2.setBounds(192, 40, 54, 15);
		panel.add(lable2);
		
		mnum = new JTextField("");
		mnum.setBounds(243, 36, 66, 21);
		panel.add(mnum);
		mnum.setColumns(10);
		
		JButton button_1 = new JButton("添加");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jc=textField.getText();
				String number=mnum.getText();
				Socket s=null;
				ObjectInputStream in = null;
				ObjectOutputStream out =null;
				try{
					s=new Socket(Data.IP,8888);
					out=new ObjectOutputStream(s.getOutputStream());
					out.writeObject("0026");
					out.writeObject(jc+" "+mnum.getText()+" "+"药品");//简称+数量+类型
					out.writeObject(doctor);
					out.flush();
					in=new ObjectInputStream(s.getInputStream());
					String name=(String)in.readObject();//接收药品名称
					String result=name+" "+"x"+mnum.getText()+"\n";
					textArea.append(result);//显示
					
				}catch(Exception ee){
					
				}
			}
		});
		button_1.setBounds(321, 36, 93, 23);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 404, 91);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button_2 = new JButton("生成报告");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor_Result frame = new Doctor_Result(doctor);
				frame.setVisible(true);
			}
		});
		button_2.setBounds(277, 203, 93, 23);
		panel.add(button_2);
		
		JLabel label_1 = new JLabel("收费项目简称");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(0, 12, 98, 15);
		panel.add(label_1);
		
		textField_2 = new JTextField("");
		textField_2.setColumns(10);
		textField_2.setBounds(112, 7, 66, 21);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("数量");
		label_3.setBounds(192, 12, 54, 15);
		panel.add(label_3);
		
		cnum = new JTextField("");
		cnum.setColumns(10);
		cnum.setBounds(243, 6, 66, 21);
		panel.add(cnum);
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jc=textField_2.getText();
				String number=mnum.getText();
				Socket s=null;
				ObjectInputStream in = null;
				ObjectOutputStream out =null;
				try{
					s=new Socket(Data.IP,8888);
					out=new ObjectOutputStream(s.getOutputStream());
					out.writeObject("0026");
					out.writeObject(jc+" "+cnum.getText()+" "+"收费项目");//简称+数量+类型
					out.writeObject(doctor);
					out.flush();
					in=new ObjectInputStream(s.getInputStream());
					String name=(String)in.readObject();//接收收费项目名称
					String result=name+" "+"x"+cnum.getText()+"\n";
					textArea.append(result);//显示
					
				}catch(Exception ee){
					
				}
			}
		});
		button.setBounds(321, 6, 93, 23);
		panel.add(button);
	}
}
