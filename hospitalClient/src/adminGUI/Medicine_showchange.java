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

public class Medicine_showchange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_showchange frame = new Medicine_showchange();
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
	public Medicine_showchange() {
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
		scrollPane.setBounds(10, 10, 393, 154);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("显示药品信息");
		scrollPane.setViewportView(textArea);
		
		JLabel label = new JLabel("输入要修改的药品编号");
		label.setBounds(43, 184, 130, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(228, 181, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.setBounds(225, 218, 93, 23);
		panel.add(button);
	}
}
