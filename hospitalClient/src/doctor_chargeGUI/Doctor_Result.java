package doctor_chargeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Doctor_Result extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Result frame = new Doctor_Result();
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
	public Doctor_Result() {
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
		scrollPane.setBounds(10, 10, 404, 142);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("显示收费项目 和 药品");
		scrollPane.setViewportView(textArea);
		
		JLabel label = new JLabel("总金额");
		label.setBounds(63, 182, 54, 15);
		panel.add(label);
		
		JLabel lbldata = new JLabel("总金额DATA");
		lbldata.setBounds(230, 182, 104, 15);
		panel.add(lbldata);
		
		JButton button = new JButton("确定");
		button.setBounds(280, 218, 93, 23);
		panel.add(button);
	}
}
