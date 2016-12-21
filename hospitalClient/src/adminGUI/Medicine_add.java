package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Medicine_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_add frame = new Medicine_add(new Administrator("a","a"));
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
	public Medicine_add(Administrator admin) {
		this.admin=admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("药品名称");
		label.setBounds(65, 32, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("添加药品");
		label_1.setBounds(169, 10, 54, 15);
		panel.add(label_1);
		
		textField = new JTextField("药品名称");
		textField.setBounds(245, 29, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("药品简称");
		label_2.setBounds(65, 69, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField("药品简称");
		textField_1.setBounds(245, 66, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("药品单位");
		label_3.setBounds(65, 104, 54, 15);
		panel.add(label_3);
		
		textField_2 = new JTextField("药品单位");
		textField_2.setBounds(245, 101, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("药品价格");
		label_4.setBounds(65, 138, 54, 15);
		panel.add(label_4);
		
		textField_3 = new JTextField("药品价格");
		textField_3.setBounds(245, 135, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("药品编号");
		label_5.setBounds(65, 170, 54, 15);
		panel.add(label_5);
		
		textField_4 = new JTextField("药品编号");
		textField_4.setBounds(245, 167, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("药品库存量");
		label_6.setBounds(65, 195, 66, 15);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setText("药品库存量");
		textField_5.setBounds(245, 192, 66, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("添加药品");
		button.setBounds(114, 220, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(255, 220, 93, 23);
		panel.add(button_1);
	}
}
