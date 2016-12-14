package utility;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
	private Connection conn;
	private Statement st; 

	public jdbc() { //初始化,连接数据库  数据库名hospitalSystem 用户名"sa" 密码"sa"
		conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hospitalSystem","sa","sa");;
			st=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean insert(String sqlStr){ //插入
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
	
	public boolean delete(String sqlStr){ //删除
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
	
	public boolean update(String sqlStr){ //改
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
	
	public ResultSet select(String sqlStr){ //查询，如果没查询到返回null,否则返回一个结果集ResultSet
		ResultSet rs=null;
		try {
			rs=st.executeQuery(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
