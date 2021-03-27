import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class JDBCTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {	
			Connection conn;
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\HLEE\\db_univ7.db", "root", "root"); 
		    System.out.println("Connection to SQLite has been established.");
		    Statement stmt = conn.createStatement(); 
		   	
		    ResultSet rs = stmt.executeQuery("select dept_name, avg (salary) as avg_salary from instructor group by dept_name");
			while (rs.next()) {
				System.out.println(rs.getString("dept_name") + " " + rs.getFloat(2));				
			}
			String inp_dep_name="Finance";
			PreparedStatement pStmt = conn.prepareStatement("insert into instructor values(?,?,?,?)");
			pStmt.setString(1, "93679");      
			pStmt.setString(2, "Perry5");
			pStmt.setString(3, inp_dep_name);   
			pStmt.setInt(4, 125000);
			pStmt.executeUpdate();    
			
			rs = stmt.executeQuery("select * from instructor");
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));				
			}	
		
		

		    stmt.close();	
		    conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}