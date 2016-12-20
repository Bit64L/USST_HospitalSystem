package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Default extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Default frame = new Default();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter(){
						
						 public void windowClosing(WindowEvent e)
						   {
						       System.exit(0);
						   }
							}
							);
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Default() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("系统账号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(45, 105, 138, 30);
		panel.add(button);
		
		JButton btnNewButton = new JButton("科室信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(225, 105, 138, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("药品信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(45, 172, 138, 30);
		panel.add(btnNewButton_1);
		
		JButton button_1 = new JButton("项目收费信息");
		button_1.setBounds(225, 172, 138, 30);
		panel.add(button_1);
		
		JLabel label = new JLabel("管理员界面");
		label.setBounds(163, 10, 138, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("增删改下列信息");
		label_1.setBounds(291, 59, 100, 15);
		panel.add(label_1);
		
		JButton button_2 = new JButton("返回？注销？");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(269, 218, 145, 23);
		panel.add(button_2);
	}
}
