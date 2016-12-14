package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class Change {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change window = new Change();
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
	public Change() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("请输入 要修改的ID号");
		lblid.setBounds(62, 189, 121, 15);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(242, 186, 103, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(62, 228, 103, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(242, 228, 103, 23);
		panel.add(button_1);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		textArea.setText("在这里输出");
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);

		
		
		
		
		
	}
}
