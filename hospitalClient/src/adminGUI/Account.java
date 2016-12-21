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

public class Account extends JFrame {

	private JPanel contentPane;
	private Administrator admin;
	/**
	 * Create the frame.
	 */
	public Account(Administrator admin) {
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
		
		JButton button = new JButton("添加账号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account_add account_add=new Account_add(admin);
				account_add.setVisible(true);
			}
		});
		button.setBounds(59, 67, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("修改账号");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account_change account_change=new Account_change(admin);
				account_change.setVisible(true);
			}
		});
		button_1.setBounds(237, 67, 93, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("删除账号");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_2.setBounds(59, 149, 93, 23);
		panel.add(button_2);
		
		JLabel label = new JLabel("系统账号管理页面");
		label.setBounds(145, 20, 160, 15);
		panel.add(label);
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_3.setBounds(237, 149, 93, 23);
		panel.add(button_3);
	}

}
