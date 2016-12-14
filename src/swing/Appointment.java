package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Appointment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment();
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
	public Appointment() {
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
		
		JLabel label = new JLabel("病人信息");
		label.setBounds(179, 0, 48, 15);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(112, 31, 24, 15);
		
		textField = new JTextField();
		textField.setBounds(234, 28, 66, 21);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(112, 62, 24, 15);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 59, 66, 21);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("手机号");
		label_3.setBounds(112, 93, 36, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 90, 66, 21);
		textField_2.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(112, 118, 12, 15);
		
		textField_3 = new JTextField();
		textField_3.setBounds(234, 121, 66, 21);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("科室");
		label_4.setBounds(112, 151, 24, 15);
		
		JLabel label_5 = new JLabel("预约时间");
		label_5.setBounds(112, 182, 48, 15);
		
		 DateChooserJButton button=new DateChooserJButton ();
		
		panel.setLayout(null);
		panel.add(label_1);
		panel.add(label_2);
		panel.add(label_3);
		panel.add(lblId);
		panel.add(label_4);
		panel.add(textField_3);
		panel.add(textField_2);
		panel.add(textField_1);
		panel.add(textField);
		panel.add(label_5);
		panel.add(label);
		panel.add(button);
		
		textField_5 = new JTextField();
		textField_5.setBounds(234, 179, 66, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("预约医生");
		label_6.setBounds(112, 217, 54, 15);
		panel.add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(234, 148, 66, 21);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(234, 214, 66, 21);
		panel.add(comboBox_1);
		
		DateChooserJButton  jb = new DateChooserJButton();
	}
}
