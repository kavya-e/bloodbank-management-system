import java.sql.*;
import java.sql.DriverManager;

/**
 * 
 */

/**
 
 *
 */
public class testing{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dburl ="jdbc:oracle:thin:@218.248.07:1521:rdbms";
		String us = "it19737049";
		String pas ="vasavi";
		try {
			Connection  conn=DriverManager.getConnection(dburl,us,pas);
			System.out.println("Connected");
			String sql ="INSERT INTO Sailors(sid,sname,rating,age)"
					    +"VALUES('6','PAl',9,90.5)";
			Statement s =conn.createStatement();
			int rows = s.executeUpdate(sql);
			if(rows>0) {
				System.out.println("Inserted Successfully");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}