package com.generic.scripts;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbfunctions {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		
	 String ShuttlDBQa="jdbc:mysql://52.76.84.56/shuttl";
	 String ShuttlDBQaUserName="stage";
	 String ShuttlDBQaPassword="shuttl";
	
	 String ShuttlDBProd="jdbc:mysql://52.74.42.151/shuttl";
	 String ShuttlDBProdUserName="analytics";
	 String ShuttlDBProdPassword="analytics@123";
	
	 String UMSDBQa="jdbc:mysql://52.77.228.1/USER_MANAGEMENT_SYSTEMS";
	 String UMSDBQaUserName="manish";
	 String UMSDBQaPassword="shuttl";
	
	 String UMSDBProd="jdbc:mysql://52.76.110.199/shuttl";
	 String UMSDBProdUserName="ums_read_only";
	 String UMSDBProdPassword="uro24680";
	
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con2=DriverManager.getConnection(ShuttlDBQa,ShuttlDBQaUserName,ShuttlDBQaPassword);  
    	Connection con1=DriverManager.getConnection(UMSDBQa,UMSDBQaUserName,UMSDBQaPassword);  
		 Statement stmt1=con1.createStatement();

		ResultSet rs=stmt1.executeQuery("select * from BOOKINGS where BOOKING_ID=746416");
		if(rs.next()){
	    System.out.println("booking id exists");
    	System.out.println("BOOKING_ID : " + rs.getInt("BOOKING_ID"));
		System.out.println("ROUTE_ID : " + rs.getInt("ROUTE_ID"));
		System.out.println("USER_ID : "+rs.getInt("USER_ID"));
		System.out.println("FROM_LOCATION_ID : " + rs.getInt("FROM_LOCATION_ID"));
		System.out.println("TO_LOCATION_ID : "+ rs.getInt("TO_LOCATION_ID"));
		System.out.println("STATUS : "+rs.getString("STATUS"));
		System.out.println("TRIP_ID : "+rs.getInt("TRIP_ID"));
	    System.out.println("ROUTE_ID : "+rs.getInt("ROUTE_ID"));
		int tripId=rs.getInt("TRIP_ID");
		int routeId=rs.getInt("ROUTE_ID");
	 
		String query1="select * from slots where routeid="+routeId+" and deleted=0 order by timeinmins";
		String query3="select id,name from locations where id in(select locationid from slots where routeid="+routeId+" and deleted=0 order by timeinmins)";
		String query4="select * from Trip where id=5";
		PreparedStatement stmt2=con2.prepareStatement(query1); 
		PreparedStatement stmt3=con2.prepareStatement(query3); 
		PreparedStatement stmt4=con2.prepareStatement(query4); 
		
		ResultSet rs3=stmt3.executeQuery();  
		while(rs3.next()){  
			System.out.println(rs3.getString("id") +" : " +rs3.getString("name"));  
			}
		ResultSet rs2=stmt2.executeQuery();  
		while(rs2.next()){  
			System.out.println(rs2.getString("locationid"));  
			}  
		System.out.println("jhdgssgdggrfjea" + query4);
		ResultSet rs4=stmt4.executeQuery();  
		while(rs4.next()){  
			System.out.println("jhdgfjea");
			System.out.println("trip details "+rs4.getString("driverid")+rs4.getString("driverStartTime")+rs4.getString("driverEndTime"));  
			long starttime=rs4.getLong("startTime");
			con(starttime);
		}  
	}
		else{
			System.out.println("booking does not exists");
		}
	}

public static void con(long epoch){
	Date date = new Date(epoch);
System.out.println(epoch);
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	String dateString = formatter.format(date);
System.out.println(dateString);
	formatter = new SimpleDateFormat("hh:mm a");  //<-- the "a" is the AM/PM marker
	String time = formatter.format(date);
	System.out.println("skjfsjf"+ time);
}
}