package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class NoAppointment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoAppointment window = new NoAppointment();
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
	public NoAppointment() {
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
		
		JLabel label = new JLabel("录入挂号信息");
		label.setBounds(160, 23, 79, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setBounds(136, 62, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("年龄:");
		label_2.setBounds(136, 87, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("联系方式:");
		label_3.setBounds(136, 112, 54, 15);
		panel.add(label_3);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setBounds(210, 62, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("age");
		lblNewLabel_1.setBounds(210, 87, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phoneNumber");
		lblNewLabel_2.setBounds(210, 112, 111, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label_4 = new JLabel("科室:");
		label_4.setBounds(136, 137, 54, 15);
		panel.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"牙科", "小儿科", "外科", "内科"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(198, 137, 91, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("医生:");
		lblNewLabel_3.setBounds(136, 168, 54, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("医生姓名");
		lblNewLabel_4.setBounds(198, 168, 54, 15);
		panel.add(lblNewLabel_4);
		
		JButton button = new JButton("确认");
		button.setBounds(136, 193, 93, 23);
		panel.add(button);
	}
	public JFrame getJFrame(){
		return frame;
	}
}
