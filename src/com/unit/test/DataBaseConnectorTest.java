package com.unit.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.jdbcsimple.DataBaseConnector;
import com.jdbcwork.DataBaseOperater;

import junit.framework.TestCase;

public class DataBaseConnectorTest extends TestCase {

	String dataBaseUrl = "jdbc:mysql://localhost:3306/bankofviz";

	Logger logger =Logger.getLogger("com.unit.test.DataBaseConnectorTest");
	
	public void testOneGreaterthanZero () 
	{
		assertTrue(1>0);
	}

	
	public void testDataBaseConnection() throws ClassNotFoundException, IOException 
	{
	     assertNotNull( DataBaseConnector.getConnection(DataBaseOperater.dataBaseUrl));	
	}
	
	
	public void testDataBaseConnectivity() throws ClassNotFoundException,
			IOException {
		System.out.println("NOW running " + getName());
		assertNotNull(DataBaseConnector.getConnection(dataBaseUrl));
	}

	public void testcheckAllAccounts() throws ClassNotFoundException,
			IOException, SQLException {
		logger.info("Now Running" +getName());
		assertNotNull(DataBaseOperater.doesUserExist("junaid", "training"));
	
	}
	
	public void testAddUser() throws SQLException, ClassNotFoundException, IOException 
	{
		logger.info("Now Running" +getName());
		DataBaseOperater.addUser("junaid", "train");
	
	}
}
