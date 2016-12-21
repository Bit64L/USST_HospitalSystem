package doctor_charge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Doctor_Charge extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Charge frame = new Doctor_Charge();
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
	public Doctor_Charge() {
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
		label.setBounds(100, 10, 77, 15);
		panel.add(label);
		
		textField = new JTextField("简称");
		textField.setBounds(187, 7, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查找");
		button.setBounds(277, 6, 93, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("药品名称");
		label_1.setBounds(10, 39, 54, 15);
		panel.add(label_1);
		
		JLabel lbldata = new JLabel("药品名称data");
		lbldata.setBounds(74, 39, 77, 15);
		panel.add(lbldata);
		
		JLabel label_2 = new JLabel("数量");
		label_2.setBounds(174, 39, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField("数量");
		textField_1.setBounds(219, 36, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("添加");
		button_1.setBounds(295, 35, 93, 23);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 404, 91);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("药品信息");
		scrollPane.setViewportView(textArea);
		
		JButton button_2 = new JButton("生成报告");
		button_2.setBounds(277, 203, 93, 23);
		panel.add(button_2);
	}
}
