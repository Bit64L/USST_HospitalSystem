package adminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import person.Administrator;

public class Office_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Administrator admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_add frame = new Office_add(new Administrator("a","a"));
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
	public Office_add(Administrator admin) {
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
		
		JLabel label = new JLabel("科室名称");
		label.setBounds(80, 45, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("科室编号");
		label_1.setBounds(80, 126, 54, 15);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(198, 42, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 123, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确认添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket s=null;
				ObjectOutputStream out=null;
				ObjectInputStream in =null;
				try {
					s=new Socket("127.0.0.1",8888);
					out=new ObjectOutputStream(s.getOutputStream());
					out.writeObject("0013");
					out.writeObject(textField.getText()+" "+textField_1.getText());
					out.writeObject(admin);
					out.flush();
					s.close();
					out.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button.setBounds(97, 188, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(263, 188, 93, 23);
		panel.add(button_1);
	}
}
