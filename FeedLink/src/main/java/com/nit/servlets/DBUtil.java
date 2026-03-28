package com.nit.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"mahibunnisa",
				"oracle"
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}