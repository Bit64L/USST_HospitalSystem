package president_duan;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

import org.omg.CORBA.INV_OBJREF;

public class President implements Serializable{
	public String presidentID;
	public String name;
	public String password;
	public President() {
		// TODO Auto-generated constructor stub
	}
	 public President(String patientID,String name,String password) {
		 this.presidentID=presidentID;
		 this.name=name;
		 this.password=password;
	 }
	
	public ResultSet getDoctorInformation(President president) throws SQLException {
		// TODO Auto-generated method stub
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
		
		try {
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			inobj=new ObjectInputStream(socket.getInputStream());
//			outobj.writeObject("院长登录");
//			outobj.writeObject(president);
//			outobj.flush();
//			String result;
//			
//			try {
//				inobj=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//				result = (String) inobj.readObject();
//				if(result.equals("success")){
//					JOptionPane.showConfirmDialog(null, "登录成功！");
//				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//---------------------登录成功后
			
			outobj.writeObject("院长要医生信息");
			outobj.flush();
			try {
				RowSetFactory rsf=RowSetProvider.newFactory();
       			CachedRowSet crs=rsf.createCachedRowSet();
       			crs=(CachedRowSet) inobj.readObject();
				ResultSet rs=crs;
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return null;
	}
	
	public ResultSet getHospitalDepartmentInformation(President president) throws SQLException {
		// TODO Auto-generated method stub
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
		
		try {
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			inobj=new ObjectInputStream(socket.getInputStream());

			
			outobj.writeObject("院长要科室信息");
			outobj.flush();
			try {
				RowSetFactory rsf=RowSetProvider.newFactory();
       			CachedRowSet crs=rsf.createCachedRowSet();
       			crs=(CachedRowSet) inobj.readObject();
				ResultSet rs=crs;
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return null;
	}
	
	public ResultSet getMedicineInformation(President president) throws SQLException {
		// TODO Auto-generated method stub
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
		
		try {
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			inobj=new ObjectInputStream(socket.getInputStream());

			
			outobj.writeObject("院长要药品信息");
			outobj.flush();
			try {
				RowSetFactory rsf=RowSetProvider.newFactory();
       			CachedRowSet crs=rsf.createCachedRowSet();
       			crs=(CachedRowSet) inobj.readObject();
				ResultSet rs=crs;
				return rs;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return null;
	}
	
	
	
	
}

