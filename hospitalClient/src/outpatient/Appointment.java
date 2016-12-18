package outpatient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Appointment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment();
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
	public Appointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("该病人已预约!");
		label.setBounds(161, 24, 112, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setBounds(118, 49, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("姓名信息");
		label_2.setBounds(182, 49, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("年龄:");
		label_3.setBounds(118, 74, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("年龄信息");
		label_4.setBounds(182, 74, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("科室:");
		label_5.setBounds(118, 124, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("科室信息");
		label_6.setBounds(182, 124, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("预约时间:");
		label_7.setBounds(118, 149, 54, 15);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("时间信息");
		label_8.setBounds(182, 149, 54, 15);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("预约医生:");
		label_9.setBounds(118, 174, 54, 15);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("医生姓名");
		label_10.setBounds(182, 174, 54, 15);
		panel.add(label_10);
		
		JButton button = new JButton("确认");
		button.setBounds(143, 228, 93, 23);
		panel.add(button);
		
		JLabel label_11 = new JLabel("联系方式:");
		label_11.setBounds(118, 99, 54, 15);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("电话号码");
		label_12.setBounds(182, 99, 54, 15);
		panel.add(label_12);
	}
	public JFrame getJFrame(){
		return frame;
	}
}
