package com.GenricUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This Class is for Database generic Methods
 * @author Raki
 *
 */
public class DataBaseutilities {

	
	
	Connection con = null;
	/**
	 * This method is for creating the connection
	 * @throws Throwable
	 */
	public void createConnection () throws Throwable {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_USERNAME, IpathConstants.DB_PASSWORD);
		
	}
	
	/**
	 * this method is for executing Querry which is only for Select function (DQL)
	 * @param Selectquerry
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuerry (String Selectquerry) throws Throwable {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(Selectquerry);
		return result;
		
	}
	
	/**
	 * This method is for updating querry which is for Non-Select querry function
	 * @param NonSelectquerry
	 * @return
	 * @throws Throwable
	 */
	public int  updateQuerry (String NonSelectquerry) throws Throwable {
		Statement state = con.createStatement();
		int result = state.executeUpdate(NonSelectquerry);
		return result;
		
	}
	
	/**
	 * to Close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		
		con.close();
	}
 	
	
}
