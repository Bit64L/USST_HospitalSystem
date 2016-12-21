package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Administrator;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Item extends JFrame {

	private JPanel contentPane;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item frame = new Item(new Administrator("a","a"));
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
	public Item(Administrator admin) {
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
		
		JLabel label = new JLabel("收费项目信息");
		label.setBounds(165, 10, 96, 15);
		panel.add(label);
		
		JButton button = new JButton("添加收费项目");
		button.setBounds(55, 63, 127, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("修改收费项目信息");
		button_1.setBounds(241, 63, 138, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("删除收费项目");
		button_2.setBounds(55, 147, 118, 23);
		panel.add(button_2);
	}

}
