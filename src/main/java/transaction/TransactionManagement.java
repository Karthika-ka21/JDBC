package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagement {
	private static String url="jdbc:postgresql://localhost:5432/airlines";
	private static String user="postgres";
	private static String pswd="123";

public static void main(String[] args) {
	try {
		//step 1
		Class.forName("org.postgresql.Driver");
		
		//step 2
		Connection conn=DriverManager.getConnection(url, user, pswd);
		
		conn.setAutoCommit(false);
		
		//step 3
		Statement st=conn.createStatement();
		System.out.println("Statement Created");
		
		String sql1="insert into flight values(101,'AirAsia','BLR','TVM')";
		st.executeUpdate(sql1);
		
		String sql2="insert into passenger values(120,'karthika',22,8000)";
		st.executeUpdate(sql2);
		String sql3="insert into passenger values(122,'karthik',25,8000)";
		st.executeUpdate(sql3);
		String sql4="insert into payment values(201,'upi','success')";
		st.executeUpdate(sql4);
		if(Payment.isSuccess()) {
			conn.commit();
			System.out.println("payment successfull...");
		}
		else {
			conn.rollback();
			System.out.println("payment failed");
		}
			
}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
