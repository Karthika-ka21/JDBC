package mavanproject1.stdupdation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StdntDataInsrtn {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pswd="123";

	public static void main(String[] args) {
		try {
			//step 1
			Class.forName("org.postgresql.Driver");
			
			//step 2
			Connection conn=DriverManager.getConnection(url, user, pswd);
			
			//step 3
			Statement st=conn.createStatement();
			System.out.println("Statement Created");
			
			String sql1="insert into student values(101,'Karthika',22)";
			String sql2="insert into student values(104,'Kavya',20)";
			String sql3="select * from student";
			
			//step 4
			//System.out.println(st.execute(sql1));
			ResultSet res=st.executeQuery(sql3);
			//System.out.println(st.executeUpdate(sql2));
			//st.executeQuery(sql2);
			
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				int age=res.getInt(3);
				
				System.out.println("Id "+id);
				System.out.println("Name "+name);
				System.out.println("Age "+age);
				System.out.println("_______________________");
				
			}
			
			//step 5
			conn.close();
			System.out.println("Connection closed");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
