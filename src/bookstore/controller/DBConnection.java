package bookstore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection makeConnection(){
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "blue";
		String pw = "123456";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB Load Successed!");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connection Successed!");
		} catch (ClassNotFoundException ex) {
			System.out.println("No such DB Driver or requirements");
		} catch (SQLException e) {
			System.out.println("DB Connection Failed!");
		}
		return con;
	}
}
