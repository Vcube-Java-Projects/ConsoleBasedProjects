package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {
	static Connection c;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;

	}

}
