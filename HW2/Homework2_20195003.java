import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class Homework2_20195003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn;
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\kgbko1117\\Desktop\\My Folder\\GitRepo\\Database_in_School\\HW2\\shopingmall.db");
			System.out.println("Connection to SQLite has been established.");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select prod_id, name, price from Product where price between 20000 and 150000");
			while (rs.next()) {
				System.out.println(rs.getString("prod_id") + " " + rs.getString("name") + " " + rs.getString("price"));			
			}
			
			rs = stmt.executeQuery("select * from Ordered where payment_status = 'Y'");
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(7));
			}
			//Show Except Status (payment_status, deliver_status)
			
			stmt.close();	
		    conn.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
