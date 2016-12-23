package utility;

import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	private Connection conn;
	private Statement st; 
	
	public DB() { //连接sql server  用户名"sa" 密码"sa"
		conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hospitalSystem","sa","sa");;
			if(conn!=null)System.out.println("连接成功!");
			this.st=conn.createStatement();
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
	
	public boolean update(String sqlStr){ //更新
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
	
	public ResultSet select(String sqlStr){ //获得ResultSet,就算什么都查不到也不可能为null
		ResultSet rs=null;
		try {
			rs=st.executeQuery(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public CachedRowSet selectGetCashedRowSet(String sqlStr){ //resultset不能用于socket通信，必须是cachedrowSet!	
		RowSetFactory rsf=null;
		ResultSet rs=null;
		try {
			rsf = RowSetProvider.newFactory();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CachedRowSet crs=null;
		try {
			crs = rsf.createCachedRowSet();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs=st.executeQuery(sqlStr);
			crs.populate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return crs;
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
