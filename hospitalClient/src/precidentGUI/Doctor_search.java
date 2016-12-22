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

public class Doctor_search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_search frame = new Doctor_search();
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
	public Doctor_search() {
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
		scrollPane.setBounds(10, 22, 404, 121);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("医生就诊量和金额");
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("确定");
		button.setBounds(306, 186, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("就诊数量生成报表");
		
		DB db = new DB();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = db.select("select * from Doctor");
				DoctornumPie.main(rs);
			}
		});
		button_1.setBounds(10, 186, 136, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("就诊金额生成报表");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = db.select("select * from Doctor");
				Doctormoney.main(rs);
			}
		});
		button_2.setBounds(156, 186, 140, 23);
		panel.add(button_2);
	}
}
