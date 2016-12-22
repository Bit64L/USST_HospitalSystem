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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Medicine_search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_search frame = new Medicine_search();
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
	public Medicine_search() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		DB db = new DB();
		ResultSet rs = db.select("select *from Medicine");
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 404, 189);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		try {
			while(rs.next())
			textArea.setText(textArea.getText()+"\n"+"药品名称："+rs.getString("medicineID"
						+"药品库存量："+rs.getInt("deposit")));
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				Precident_default.main(args);
			}
		});
		button.setBounds(261, 218, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("生成报表");

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicinePie.main(rs);
			}
		});
		button_1.setBounds(82, 218, 93, 23);
		panel.add(button_1);
	}
}
