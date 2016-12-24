package registrationGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import person.Patient;
import staff.ChargeItem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Charge_2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Charge_2 frame = new Charge_2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Charge_2(Patient patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JTextArea textArea = new JTextArea();
		ArrayList<ChargeItem> chargeItems=patient.getChargeItems();
		String head="Name ShortName Unit Price No";
		for(ChargeItem ch:chargeItems){
			String body=ch.getName()+ch.getShortName()+ch.getUnit()+ch.getPrice()+ch.getNo()+"\n";
			textArea.append(body);
		}
		textArea.setBounds(10, 0, 414, 157);
		textArea.getScrollableTracksViewportHeight();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textArea);
		textArea.setText("显示收费信息");
		scrollPane.setBounds(10, 10, 414, 151);	
		panel.add(scrollPane);
		
		JLabel label = new JLabel("费用总额:");
		label.setBounds(117, 181, 77, 15);
		panel.add(label);
		
		JLabel lbldata = new JLabel("费用总额DATA");
		lbldata.setBounds(218, 181, 88, 15);
		panel.add(lbldata);
		
		JButton button = new JButton("确认收费信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//发送信息:病人已收费
				//回传
				Registration reg=new Registration();
				Patient inPatient=reg.sendPatientPayment(patient);
				if(inPatient.getChargestate())
				    JOptionPane.showMessageDialog(null, "付费成功");  
				else
				    JOptionPane.showMessageDialog(null, "付费失败");  

			}
		});
		button.setBounds(150, 218, 105, 23);
		panel.add(button);
	}

}
