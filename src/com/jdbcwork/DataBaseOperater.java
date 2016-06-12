package com.jdbcwork;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.bov.dto.Account;
import com.bov.dto.User;
import com.bov.dto.UserExtended;
import com.jdbcsimple.DataBaseConnector;

public class DataBaseOperater {
public 	static String dataBaseUrl = "jdbc:mysql://localhost:3306/bankofviz";
	static Logger logger = Logger.getLogger("com.jdbcwork.DataBaseOperater");

	public static List<Account> getAllAccounts() throws ClassNotFoundException,
			IOException {

		List<Account> accountList = new ArrayList<Account>();
		Connection conn = DataBaseConnector.getConnection(dataBaseUrl);
		// Prepare a stmt class
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery("select * from account");
			while (rst.next()) {
				// Create a new Account Object and insert the column value from
				// database into this Object
				Account accountObject = new Account();				
				accountObject.setId(rst.getInt("id"));
				//accountObject.setId(rst.getInt("Id"));
				accountObject.setName(rst.getString("Name"));
				accountObject.setAccountOne(rst.getString("FirstAccountType"));
				accountObject.setAccountTwo(rst.getString("SecondAccountType"));
				accountObject.setAccountNumberOne(rst
						.getString("AccountNumberOne"));
				accountObject.setAccountNumberTwo(rst
						.getString("AccountNumberTwo"));
				accountObject.setLoanType(rst.getString("LoanType"));
				accountList.add(accountObject);

			}

		} catch (SQLException expe) {
			expe.printStackTrace();
			while (expe != null) {
				String logMessage = "\n SQL Error: " + expe.getMessage()
						+ "\n\t\t" + "Error code: " + expe.getErrorCode()
						+ "\n\t\t" + "SQLState: " + expe.getSQLState() + "\n";
				System.out.println(logMessage);

			}

		}

		// Uncomment the below line during real application testing
		showValues(accountList);
		return accountList;
	}

	public static Account getAccount(int id) throws SQLException,
			ClassNotFoundException, IOException {
		// Under stand Prepared Statement Logic here
		Account accountObject = null;
		Connection conn = DataBaseConnector.getConnection(dataBaseUrl);
		String sqlQuery = "select * from Account where id = ?";

		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		//ps.setInt(1, 10); // Meaning is it will change select * from Account where id=10//
		ps.setInt(1, id);// Set the Input Parameter
	 
		// It will change the SELECT * FROM account WHERE Id=2 AND NAME='Abdul Ahad';
		
		ResultSet rst = ps.executeQuery();
		while (rst.next()) {
			accountObject = new Account();
			accountObject.setId(id);
			accountObject.setName(rst.getString("Name"));
			accountObject.setAccountOne(rst.getString("FirstAccountType"));
			accountObject.setAccountTwo(rst.getString("SecondAccountType"));
			accountObject
					.setAccountNumberOne(rst.getString("AccountNumberOne"));
			accountObject
					.setAccountNumberTwo(rst.getString("AccountNumberTwo"));
			accountObject.setLoanType(rst.getString("LoanType"));

		}
		conn.close();
		showAccount(accountObject);
		return accountObject;

	}

	private static void showValues(List<Account> accountList) {

		for (Account act : accountList) {
			System.out.println(act.getId());
			System.out.println(act.getName());
			System.out.println(act.getAccountOne());
			System.out.println(act.getAccountTwo());
			System.out.println(act.getAccountNumberOne());
			System.out.println(act.getAccountNumberTwo());
			System.out.println(act.getLoanType());
			System.out.println(act.getLoanAmount());
		}

	}

	private static void showAccount(Account acct) {

		logger.info("Id is " + acct.getId());
		logger.info(acct.getName());
		logger.info(acct.getAccountOne());
		logger.info(acct.getAccountTwo());
		logger.info(acct.getAccountNumberOne());
		logger.info(acct.getAccountNumberTwo());
		logger.info(acct.getLoanType());
		logger.info(acct.getLoanAmount());

	}

	public static User doesUserExist(String username, String password)
			throws SQLException, ClassNotFoundException, IOException {

		User user = null;
		Connection conn = DataBaseConnector.getConnection(dataBaseUrl);
		String sqlQuery = "select * from user where username=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, username);// Set the Input Parameter
		ps.setString(2, password);// Set the second PArameter
		ResultSet rst = ps.executeQuery();

		while (rst.next()) {
			user = new User();
			user.setId(rst.getInt("id"));
			user.setUserName(rst.getString("username"));
			user.setPassword(rst.getString("password"));
		}
		UserExtended userExtended=new UserExtended();
		userExtended.setEmailAddress("junaid.jp@gmail.com");
		showUser(userExtended);
		return user;

	}

	private static void showUser(UserExtended user) {

if(user==null){
	logger.info("USER DOES NOT EXIST" );
}
else {
	logger.info(""+user.getId());
	logger.info(user.getUserName());
	logger.info(user.getPassword());
	System.out.println(user.getEmailAddress());
	
}
	}
	
	
	public static Account getAccountByUserId(User user) throws SQLException, ClassNotFoundException, IOException{
		return getAccount(user.getId());
		
		
	}
	
	
	public static void addUser(String username,String password) throws SQLException, ClassNotFoundException, IOException{
	 	
		Connection conn = DataBaseConnector.getConnection(dataBaseUrl);
		
		//get the size of the rows from  user table
		
		String sql="select * from user";
		Statement st=conn.createStatement();
	
		ResultSet rst=st.executeQuery(sql);
	
		rst.last();
		int maxRows=rst.getRow();
		System.out.println(rst.getRow());
		
		 String sqlQuery =
			  "insert into user (id,username,password) values(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, maxRows+1);
		ps.setString(2, username);// Set the Input Parameter
		ps.setString(3, password);// Set the second PArameter
		ps.executeUpdate();
		ps.close();
		conn.close();


		
	}
	
	
	public static void deleteUser(String username) throws ClassNotFoundException, IOException, SQLException{
		Connection conn = DataBaseConnector.getConnection(dataBaseUrl);
		String sqlQuery="delete from user where username=?";
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setString(1,username );
		ps.executeUpdate();
		conn.close();
	}
	
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException{
		addUser("junaid","train");
		deleteUser("junaid");
		doesUserExist("veni","training");
	}


	
	

}
