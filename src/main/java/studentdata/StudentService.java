package studentdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pswd="123";
	static Connection conn;
	
	static {
		
			//step 1
			try {
				Class.forName("org.postgresql.Driver");
				//step 2
				conn = DriverManager.getConnection(url, user, pswd);
				//step 3
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	int save(Student s) {
		int res=0;
		try {
			String sql="insert into student values(?,?,?)";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, s.getId());
			st.setString(2, s.getName());
			st.setInt(3, s.getAge());
			 res=st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	int update(Student st,String field) {
		int res=0;
		try {
			String sql="update student set "+field+"=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1,field);
			if(field.equals("age")) {
				int a=st.getAge();
				pst.setInt(1, a);
			}
			else
				pst.setString(1, st.getName());
			pst.setInt(2, st.getId());
			 res=pst.executeUpdate();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
		return res;
	}
	void fetch() {
		try {
			String sql="select * from student";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet res=pst.executeQuery();
			System.out.println("ID\t\tName\t\tAge");
			while(res.next()) {
				System.out.println(res.getInt(1)+"\t\t"+res.getString(2)+"\t\t"+res.getInt(3));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	int delete(int id) {
		int res=0;
		try {
			String sql="delete from student where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			res=pst.executeUpdate();
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		return res;
	}
	boolean exit() {
		boolean flag=false;
		try {
			conn.close();
			flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
