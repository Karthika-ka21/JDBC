package mavanproject1.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pswd="123";

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver class loaded");
			 Connection con=DriverManager.getConnection(url,user,pswd);
			 System.out.println("connection established");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
