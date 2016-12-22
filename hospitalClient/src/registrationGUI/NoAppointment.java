package registrationGUI;

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
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NoAppointment extends JFrame{

	private JPanel contentPane;
	private JTextField txtPhonenumber;
	private JTextField textField;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoAppointment window = new NoAppointment();
					window.setVisible(true);
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
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
		
		JLabel label_4 = new JLabel("科室:");
		label_4.setBounds(136, 137, 54, 15);
		panel.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"牙科", "小儿科", "外科", "内科"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(198, 137, 91, 21);
		panel.add(comboBox);
		
		JButton button = new JButton("确认");
		button.setBounds(149, 194, 93, 23);
		panel.add(button);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.setText("phonenumber");
		txtPhonenumber.setBounds(198, 109, 91, 21);
		panel.add(txtPhonenumber);
		txtPhonenumber.setColumns(10);
		
		textField = new JTextField("age");
		textField.setBounds(198, 84, 91, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(198, 59, 91, 21);
		panel.add(txtName);
		txtName.setColumns(10);
	}
}
