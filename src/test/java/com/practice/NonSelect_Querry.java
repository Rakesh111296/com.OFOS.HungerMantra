package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class NonSelect_Querry {
	public static void main(String[] args) throws Throwable {

		Connection con = null;
		int result = 0;

		try {
			// register to the DB
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// get connection for the DB
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
			// create a statment
			Statement State = con.createStatement();
			String querry = "insert into student_info values ('Hey', 'S10', 'A', 10), ('HeyHey', 'S11', 'A', 11);";

			// excute update querry
			result = State.executeUpdate(querry);

			if (result == 2) {
				System.out.println("Data successfully Updated");
			}

			else {
				System.err.println("Data not been updated");
			}

			String querry1 = "select * from student_info;";
			ResultSet result1 = State.executeQuery(querry1);

			while (result1.next()) {
				System.out.println(result1.getString(1) + "  " + result1.getString(2) + "   " + result1.getString(3)
						+ "   " + result1.getString(4));
			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			// close the DB
			con.close();
		}
	}
}
