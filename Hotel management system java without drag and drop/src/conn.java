import java.sql.*;

public class conn {
	
	Connection connection;
	Statement s;
	
	public conn() {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hotel_management","");
			
			s = connection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//
//	public static void main(String[] args) {
//		conn o = new conn();
//		Connection c = o.connecttooracle();
//		System.out.print("done");
//	}
}
