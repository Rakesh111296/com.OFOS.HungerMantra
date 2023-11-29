package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Employee_Test {
	
	public static void main(String[] args) throws Throwable {
		
		
		Random r = new Random();
		int RanAge = r.nextInt(100);
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Employee Name -------->");
		String EmployeeName = sc.nextLine(); 
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
		Statement state = con.createStatement();
		
		ResultSet result = state.executeQuery("Select Ename from employeetable where Ename='"+EmployeeName+"';");
		boolean flag = false;
		
		while (result.next()) {
			
			if (EmployeeName.equalsIgnoreCase(result.getString(1))) {
				
				System.out.println("Employee Already Exist in Database");
				flag = true;
				break;
			}
		}	
			if (!flag){
				
				int result1 = state.executeUpdate("insert into employeetable values ('"+EmployeeName+"',"+RanAge+");");
				
				if(result1==1) {
					System.out.println("Employee Name Added to Database");
					ResultSet result2  = state.executeQuery("Select * from employeetable where Ename='"+EmployeeName+"';");
					
					while(result2.next()) {
						System.out.println(result2.getString(1)+"    "+result2.getString(2));
					} } } 
			
		
		con.close();
		} 
	}
