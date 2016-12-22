package precidentGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utility.DB;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Office_search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_search frame = new Office_search();
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
	public Office_search() {
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
		scrollPane.setBounds(10, 10, 404, 177);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("显示挂号量和总金额");
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("确定");
		button.setBounds(331, 203, 93, 23);
		panel.add(button);
		
		DB db = new DB();
		ResultSet rs = db.select("select * from HospitalDepartment");
		JButton button_1 = new JButton("挂号量生成报表");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficeNum.main(rs);
			}
		});
		button_1.setBounds(0, 203, 123, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("总金额生成报表");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficeMoney.main(rs);
			}
		});
		button_2.setBounds(135, 203, 158, 23);
		panel.add(button_2);
	}

}
