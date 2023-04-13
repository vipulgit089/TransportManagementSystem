package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bo.AddDriver;
import com.bo.AddTransport;
import com.bo.Signup;

public class Transport_dao {
	
	
	public static Connection Conn() throws SQLException {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/transport";
			String dbuser="root";
			String dbpass="1234";
		    con = DriverManager.getConnection(dbUrl,dbuser,dbpass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
		
	}
	
	public static int signup(Signup ob) {
		int status=0;
		
		try {
		Connection con=	Transport_dao.Conn();
		String sql="insert into transport(name,email,password) values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,ob.getName());
		ps.setString(2,ob.getEmail());
		ps.setString(3,ob.getPassword());
		status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
		}
	//LOG IN PAGE METHOD
	public static boolean login(String email,String password) {
		boolean status=false;
		try {
			Connection con=Transport_dao.Conn();
			String sql="select * from transport where email=? and password=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	// ADD DRIVER DETAILS METHOD
	public static int AddDriver(AddDriver ob) {
		int status=0;
		
		try {
		Connection con=	Transport_dao.Conn();
		String sql="insert into adddriver(name,mobile,vechile,address,license_num) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,ob.getName());
		ps.setString(2,ob.getMobile());
		ps.setString(3,ob.getVechile());
		ps.setString(4,ob.getAddress());
		ps.setString(5,ob.getLic());
		
		status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

		}
	//GET DRIVER DETAILS METHOD
	public static List ViewDriverdetails() {
		
		List<AddDriver > list= new ArrayList();
		try {
			Connection con= Transport_dao.Conn();
			String sql="Select * from adddriver";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				AddDriver ad=new AddDriver();
				ad.setId(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setMobile(rs.getString(3));
				ad.setVechile(rs.getString(4));
				ad.setAddress(rs.getString(5));
				ad.setLic(rs.getString(6));
				list.add(ad);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	//GET ID DRIVER DETAILS METHOD
	public static AddDriver getInfoID(int id) {
		AddDriver ad= new AddDriver();
		
		try {
			Connection con=Transport_dao.Conn();
			String sql="Select * from adddriver where id=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
			
				ad.setId(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setMobile(rs.getString(3));
				ad.setVechile(rs.getString(4));
				ad.setAddress(rs.getString(5));
				ad.setLic(rs.getString(6));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return ad;
	}
	//UPDATE DRIVER DETAILS METHOD
	public static int updateEmployee(AddDriver ad)
	{
	int status=0;
	try {
		Connection con=Transport_dao.Conn();
		String sql="update adddriver set name=?,mobile=?,vechile=?,address=?,license_num=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,ad.getName());
		ps.setString(2,ad.getMobile());
		ps.setString(3,ad.getVechile());
		ps.setString(4,ad.getAddress());		
		ps.setString(5,ad.getLic());
		ps.setInt(6,ad.getId());
		status=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
		return status;
	}
	//DELETE DRIVER DETAILS METHOD
	public static int deletedriver(int id) {
		int status=0;
		try {
			Connection con=Transport_dao.Conn();
			String sql="delete from adddriver where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
		
	}
	public static int addtransport(AddTransport ob) {
		int status=0;
		
		try {
		Connection con=	Transport_dao.Conn();
		String sql="insert into addtransport(Consignor_Name,Consignor_Mobile,Consignee_Name,Consignee_Mobile,Consignee_Address,Driver_Assigned) values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,ob.getConsignor_name());
		ps.setString(2,ob.getConsignor_mobile());
		ps.setString(3,ob.getConsignee_name());
		ps.setString(4,ob.getConsignee_mobile());
		ps.setString(5,ob.getConsignee_address());
		ps.setString(6,ob.getDriver_assigned());
		
		status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

		}
	
public static List ViewTransportdetails() {
		
		List<AddTransport> list= new ArrayList();
		try {
			Connection con= Transport_dao.Conn();
			String sql="Select * from addtransport";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				AddTransport ad=new AddTransport();
				ad.setId(rs.getInt(1));
				ad.setConsignor_name(rs.getString(2));
				ad.setConsignor_mobile(rs.getString(3));
				ad.setConsignee_name(rs.getString(4));
				ad.setConsignee_mobile(rs.getString(5));
				ad.setConsignee_address(rs.getString(6));
				ad.setDriver_assigned(rs.getString(7));
				list.add(ad);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

public static AddTransport getTRInfoID(int id) {
	AddTransport ad= new AddTransport();
	
	try {
		Connection con=Transport_dao.Conn();
		String sql="Select * from addtransport where id=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
		
			ad.setId(rs.getInt(1));
			ad.setConsignor_name(rs.getString(2));
			ad.setConsignor_mobile(rs.getString(3));
			ad.setConsignee_name(rs.getString(4));
			ad.setConsignor_mobile(rs.getString(5));
			ad.setConsignee_address(rs.getString(6));
			ad.setDriver_assigned(rs.getString(7));
			
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	return ad;
}

public static int updateTR(AddTransport ad)
{
int status=0;
try {
	Connection con=Transport_dao.Conn();
	String sql="update addtransport set Consignor_Name=?,Consignor_Mobile=?,Consignee_Name=?,Consignee_Mobile=?,Consignee_Address=?,Driver_Assigned=? where id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1,ad.getConsignor_name());
	ps.setString(2,ad.getConsignor_mobile());
	ps.setString(3,ad.getConsignee_name());
	ps.setString(4,ad.getConsignee_mobile());
	ps.setString(5,ad.getConsignee_address());
	ps.setString(6, ad.getDriver_assigned());
	ps.setInt(7,ad.getId());
	status=ps.executeUpdate();
} catch (Exception e) {
	System.out.println(e);
}
	return status;
}

public static int deleteTransport(int id) {
	int status=0;
	try {
		Connection con=Transport_dao.Conn();
		String sql="delete from addtransport where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		status=ps.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
	
	
}


public static int forgotpass(Signup ad)
{
int status=0;
try {
	Connection con=Transport_dao.Conn();
	String sql="update transport set password=? where email=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1,ad.getPassword());
	ps.setString(2,ad.getEmail());
	
	status=ps.executeUpdate();
} catch (Exception e) {
	System.out.println(e);
}
	return status;
}


}
