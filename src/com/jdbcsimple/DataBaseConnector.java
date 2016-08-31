package com.jdbcsimple;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {


	//This Method loads the connection Database //
	public static Connection getConnection(String connectionUrl) throws ClassNotFoundException,IOException{
	
		Connection conn = null;
	try {
		/* First load the JDBC Driver */
		 Class.forName("com.mysql.jdbc.Driver");

    	conn=DriverManager.getConnection(connectionUrl,"root","junaid123");
    	//System.out.println(conn!=null);
    	return conn;
	}
	catch(SQLException expe){
		expe.printStackTrace();
		while (expe != null) {
			String logMessage = "\n SQL Error: "+
			expe.getMessage() + "\n\t\t"+
			  "Error code: "+expe.getErrorCode() + 
                                           "\n\t\t"+
			  "SQLState: "+expe.getSQLState()+"\n";
	        System.out.println(logMessage);
	        

	}
	}
	return conn;
	}
}
