package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Medicine_delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_delete frame = new Medicine_delete();
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
	public Medicine_delete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		textArea.setText("显示药品信息");
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		
		JLabel label = new JLabel("选择要删除的药品编号");
		label.setBounds(63, 176, 142, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(224, 173, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确认删除");
		button.setBounds(111, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(248, 218, 93, 23);
		panel.add(button_1);
	}

}
