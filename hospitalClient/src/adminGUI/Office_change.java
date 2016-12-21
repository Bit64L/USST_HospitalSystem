package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Office_change extends JFrame {

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
					Office_change frame = new Office_change();
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
	public Office_change() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("科室名称");
		label.setBounds(99, 49, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(228, 46, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("科室编号");
		label_1.setBounds(99, 112, 54, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 109, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确认修改");
		button.setBounds(99, 186, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(252, 186, 93, 23);
		panel.add(button_1);
	}
}
