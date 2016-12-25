package medicine_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import person.Patient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Medicine_default extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_default frame = new Medicine_default();
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
	public Medicine_default() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("病人ID");
		lblid.setBounds(68, 45, 54, 15);
		panel.add(lblid);
		
		txtid = new JTextField();
		txtid.setText("病人ID");
		txtid.setBounds(211, 42, 66, 21);
		panel.add(txtid);
		txtid.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket socket=null;
				ObjectInputStream inobj=null;
				ObjectOutputStream outobj=null;
				
				try {
					socket=new Socket("124.76.5.175",8888);
					outobj=new ObjectOutputStream(socket.getOutputStream());
					inobj=new ObjectInputStream(socket.getInputStream());
					outobj.writeObject("药师要registerPatients Arraylist");
					outobj.flush();
					
					try {
						ArrayList<Patient> repatient=(ArrayList<Patient>) inobj.readObject();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

			}
		});
		button.setBounds(321, 41, 93, 23);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 404, 114);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("药品信息");
		scrollPane.setViewportView(textArea);
		
		JButton button_1 = new JButton("给药");
		button_1.setBounds(272, 218, 93, 23);
		panel.add(button_1);
	}
}
