package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Office_showchange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_showchange frame = new Office_showchange();
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
	public Office_showchange() {
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
		scrollPane.setBounds(10, 10, 404, 121);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("显示科室信息");
		scrollPane.setViewportView(textArea);
		
		JLabel label = new JLabel("输入要修改的科室编号");
		label.setBounds(40, 159, 133, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(231, 156, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.setBounds(204, 218, 93, 23);
		panel.add(button);
	}

}
