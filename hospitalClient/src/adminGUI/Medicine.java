package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Medicine extends JFrame {

	private JPanel contentPane;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine frame = new Medicine(new Administrator("a","a"));
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
	public Medicine(Administrator admin) {
		this.admin=admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("添加药品");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Medicine_add medicine_add=new Medicine_add(admin);
				medicine_add.setVisible(true);
			}
		});
		button.setBounds(56, 66, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("修改药品信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(246, 66, 120, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("删除药品");
		button_2.setBounds(56, 165, 93, 23);
		panel.add(button_2);
		
		JLabel label = new JLabel("药品信息");
		label.setBounds(163, 10, 54, 15);
		panel.add(label);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(257, 165, 93, 23);
		panel.add(button_3);
	}
}
