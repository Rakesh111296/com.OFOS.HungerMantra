package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC {
public static void main(String[] args) throws SQLException {
	
	//Register to the DB
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	//Get Connection for the DB
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
	//Create a statement
	Statement state = con.createStatement();
	String querry = "select * from student_info;";
	//excute a querry
	ResultSet result = state.executeQuery(querry);
	while (result.next()) {
		System.out.println(result.getString(1)+"  "+ result.getString(2)+"   "+result.getString(3)+"   "+result.getString(4));
	}
	
	// close to DB
	con.close();
}
}
