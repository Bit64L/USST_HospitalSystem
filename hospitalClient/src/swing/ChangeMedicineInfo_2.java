package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangeMedicineInfo_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeMedicineInfo_2 window = new ChangeMedicineInfo_2();
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
	public ChangeMedicineInfo_2() {
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
		
		JLabel label = new JLabel("药品名称");
		label.setBounds(106, 40, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("药品简称");
		label_1.setBounds(106, 76, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("药品单位");
		label_2.setBounds(106, 109, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("药品单价");
		label_3.setBounds(106, 145, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("药品编号");
		label_4.setBounds(106, 170, 54, 15);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(207, 37, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 73, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 106, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(207, 142, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(207, 167, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("确定");
		button.setBounds(106, 217, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(247, 217, 93, 23);
		panel.add(button_1);
	}

}
