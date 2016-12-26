package precidentGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import president_duan.President;
import utility.DB;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;;
public class Office_search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_search frame = new Office_search();
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
	public Office_search() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//DB db = new DB();
		//ResultSet rs = db.select("select * from HospitalDepartment");
		President president=new President();// new 
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 404, 177);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		ResultSet rs=null;   //new 
		try {
			rs = president.getHospitalDepartmentInformation(president);  //new 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rs.next())
			{
				textArea.setText(textArea.getText()+"\n"+"科室名称为："+rs.getString("hospitalDepartmentName")
						+"科室挂号量为："+rs.getInt("registerNum")+"科室总金额为："+rs.getDouble("money"));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Precident_default.main(args);
			}
		});
		button.setBounds(331, 203, 93, 23);
		panel.add(button);
		
		
		
		JButton button_1 = new JButton("挂号量生成报表");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=null;   //new 
				try {
					rs = president.getHospitalDepartmentInformation(president);  //new 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OfficeNum.main(rs);
			}
		});
		button_1.setBounds(0, 203, 142, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("总金额生成报表");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=null;   //new 
				try {
					rs = president.getHospitalDepartmentInformation(president);  //new 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OfficeMoney.main(rs);
			}
		});
		button_2.setBounds(152, 203, 158, 23);
		panel.add(button_2);
	}

}
