package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class RegisterCharge extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCharge frame = new RegisterCharge();
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
	public RegisterCharge() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("收费信息");
		label.setBounds(163, 21, 78, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("挂号费为：");
		label_1.setBounds(79, 119, 102, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("挂号费用");
		label_2.setBounds(212, 119, 54, 15);
		panel.add(label_2);
		
		JButton button = new JButton("确定");
		button.setBounds(148, 201, 93, 23);
		panel.add(button);
	}
}
