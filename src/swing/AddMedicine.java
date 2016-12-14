package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddMedicine {

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
					AddMedicine window = new AddMedicine();
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
	public AddMedicine() {
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
		label.setBounds(103, 53, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("药品简称");
		label_1.setBounds(103, 78, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("药品单位");
		label_2.setBounds(103, 103, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("药品单价");
		label_3.setBounds(103, 128, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("药品编号");
		label_4.setBounds(103, 152, 54, 15);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(191, 50, 100, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 75, 100, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 100, 100, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 125, 100, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 149, 100, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(103, 208, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(225, 208, 93, 23);
		panel.add(button_1);
	}

}
