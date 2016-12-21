package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Office extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office frame = new Office();
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
	public Office() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("科室信息");
		label.setBounds(173, 10, 54, 15);
		panel.add(label);
		
		JButton button = new JButton("添加科室");
		button.setBounds(45, 57, 118, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("修改科室信息");
		button_1.setBounds(256, 57, 118, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("删除科室");
		button_2.setBounds(45, 157, 118, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(256, 157, 118, 23);
		panel.add(button_3);
	}

}
