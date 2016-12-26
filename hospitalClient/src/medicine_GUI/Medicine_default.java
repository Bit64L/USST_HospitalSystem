
package medicine_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import person.Patient;
import staff.ChargeItem;
import staff.Medicine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Medicine_default extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTable table;
	private Patient wantPatient=null;
	private JTable table_1;
	private JScrollPane scrollPane;
	ArrayList<Medicine> medi=new ArrayList<>();
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
		medi=null;
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
		txtid.setBounds(134, 40, 163, 23);
		panel.add(txtid);
		txtid.setColumns(10);
		
		
		JButton button = new JButton("确定");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket socket=null;
				ObjectInputStream inobj=null;
				ObjectOutputStream outobj=null;
				
				try {
					socket=new Socket("101.94.249.251",8888);
					outobj=new ObjectOutputStream(socket.getOutputStream());
					inobj=new ObjectInputStream(socket.getInputStream());
					outobj.writeObject("药师要registerPatients Arraylist");
					outobj.flush();
					
					try {
						
						
						ArrayList<Patient> repatient=(ArrayList<Patient>) inobj.readObject();
						
						boolean exist=false;
//						boolean paymoney=false;
						
						//
					
						//
						
						
						for(Patient p: repatient){
							if(p.getId().equals(txtid.getText())){
								exist=true;
								boolean pay=p.getChargestate();
								if(pay==false){
									JOptionPane.showMessageDialog(null,"病人未缴费","提示消息", JOptionPane.WARNING_MESSAGE);
								}else{
									wantPatient=p;
									
									Vector<String> rowName=new Vector<>();
									rowName.add("药品名称");
									rowName.add("单价");
									rowName.add("数量");
									rowName.add("单位");
									
									
									Vector<Vector<String>> vData=new Vector<>();
									
									medi=p.getMedicines();
									
									for(Medicine m :p.getMedicines()){
										Vector<String> rowData=new Vector<>();
										rowData.add(m.getName());
										rowData.add(""+m.getPrice());
										rowData.add(""+m.getNumber());
										rowData.add(m.getUnit());
										
										vData.add((Vector<String>) rowData.clone());
									}
									
									//应该不要检查项目
									for(ChargeItem c :p.getChargeItems()){
										Vector<String> rowData=new Vector<>();
										rowData.add(c.getName());
										rowData.add(""+c.getPrice());
										rowData.add(""+c.getNumber());
										rowData.add(c.getUnit());
										vData.add((Vector<String>) rowData.clone());
										
									}
									
									
									
								DefaultTableModel DFM=new DefaultTableModel(vData,rowName);
								
								table_1 = new JTable(DFM);
								scrollPane.setViewportView(table_1);
								}
								
							}	
						}
						if(exist==false){
							JOptionPane.showMessageDialog(null, "病人ID不存在", "提示消息",JOptionPane.ERROR_MESSAGE); 
						}
						
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
		
		JButton button_1 = new JButton("给药");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(medi!=null){
				Socket socket=null;
				ObjectInputStream inobj=null;
				ObjectOutputStream outobj=null;
				
				try {
					socket=new Socket("101.94.249.251",8888);
					
					outobj=new ObjectOutputStream(socket.getOutputStream());
					inobj=new ObjectInputStream(socket.getInputStream());
					outobj.writeObject("药房端修改药品库存");
					outobj.flush();
					
					outobj.writeObject(medi);
					outobj.flush();
					
					String rec=(String) inobj.readObject();
					JOptionPane.showMessageDialog(null,rec);
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
				
			}
		});
		
		
		button_1.setBounds(272, 218, 93, 23);
		panel.add(button_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 66, 428, 135);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
//		information = new JTable();
//		information.setBounds(33, 76, 381, 133);
//		panel.add(information);
		
//		table = new JTable();
//		table.setBounds(19, 76, 401, 126);
//		panel.add(table);
	}
}
