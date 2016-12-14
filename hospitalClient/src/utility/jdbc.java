package utility;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
	private Connection conn;
	private Statement st; 
	
	public jdbc() { //��ʼ��,�������ݿ�  ���ݿ���hospitalSystem �û���"sa" ����"sa"
		conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hospitalSystem","sa","sa");;
			if(conn!=null)System.out.println("���ӳɹ�");
			this.st=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean insert(String sqlStr){ //����
		int rowCount=0;
		try {
			rowCount=st.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowCount>0)return true;
		else return false;
	}
	
	public boolean delete(String sqlStr){ //ɾ��
		int rowCount=0;
		try {
			rowCount=st.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowCount>0)return true;
		else return false;
	}
	
	public boolean update(String sqlStr){ //��
		int rowCount=0;
		try {
			rowCount=st.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowCount>0)return true;
		else return false;
	}
	
	public ResultSet select(String sqlStr){ //��ѯ,����һ�������ResultSet,������Ϊnull
		ResultSet rs=null;
		try {
			rs=st.executeQuery(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closeAll(){
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
