package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Medicine_change extends JFrame {

	private JPanel contentPane;
	private JTextField txtc;
	private JTextField txtc_1;
	private JTextField txtc_2;
	private JTextField txtc_3;
	private JTextField txtc_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_change frame = new Medicine_change();
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
	public Medicine_change() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("修改药品信息");
		label.setBounds(166, 10, 72, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("药品名称");
		label_1.setBounds(70, 39, 54, 15);
		panel.add(label_1);
		
		txtc = new JTextField();
		txtc.setText("药品名称C");
		txtc.setBounds(231, 36, 66, 21);
		panel.add(txtc);
		txtc.setColumns(10);
		
		JLabel label_2 = new JLabel("药品简称");
		label_2.setBounds(70, 72, 54, 15);
		panel.add(label_2);
		
		txtc_1 = new JTextField();
		txtc_1.setText("药品简称C");
		txtc_1.setBounds(231, 69, 66, 21);
		panel.add(txtc_1);
		txtc_1.setColumns(10);
		
		JLabel label_3 = new JLabel("药品单位");
		label_3.setBounds(70, 107, 54, 15);
		panel.add(label_3);
		
		txtc_2 = new JTextField();
		txtc_2.setText("药品单位C");
		txtc_2.setBounds(231, 107, 66, 21);
		panel.add(txtc_2);
		txtc_2.setColumns(10);
		
		JLabel label_4 = new JLabel("药品单价");
		label_4.setBounds(70, 144, 54, 15);
		panel.add(label_4);
		
		txtc_3 = new JTextField();
		txtc_3.setText("药品单价C");
		txtc_3.setBounds(231, 141, 66, 21);
		panel.add(txtc_3);
		txtc_3.setColumns(10);
		
		JLabel label_5 = new JLabel("药品库存量");
		label_5.setBounds(70, 179, 66, 15);
		panel.add(label_5);
		
		txtc_4 = new JTextField();
		txtc_4.setText("药品库存量C");
		txtc_4.setBounds(231, 176, 66, 21);
		panel.add(txtc_4);
		txtc_4.setColumns(10);
		
		JButton button = new JButton("确认修改");
		button.setBounds(98, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(246, 218, 93, 23);
		panel.add(button_1);
	}

}
