import java.util.*;
import java.sql.*;
public class Sqlitedemo {
public static void main(String[] args) {
	try {
		Class.forName("org.sqlite.JDBC");
		String dbURL="jdbc:sqlite:product:db";
		Connection con=DriverManager.getConnection(dbURL);
		if(con!=null) {
			System.out.println("connected");
			Statement stmt=con.createStatement();

//			stmt.executeUpdate("create table Movies(pid int primary key,pname text,release text)");
//			System.out.println("created table");

//			    int rows = stmt.executeUpdate("insert into Movies values(104,'FLIP','12.12.12')");
//			    rows = stmt.executeUpdate("insert into Movies values(105,'FLIP2','12.12.12')");
//			    rows = stmt.executeUpdate("insert into Movies values(106,'FLIP3','12.12.12')");
//			    System.out.println("inserted = "+ rows);
			    
			    //update employee record
			   int rows= stmt.executeUpdate("update Movies set release='11.11.11' where pid=104");
			    System.out.println("updated = "+ rows);
			    
			    //read employee records
			    ResultSet rs = stmt.executeQuery("Select * from Movies");
			    while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			    
			    //delete employee record
			    rows = stmt.executeUpdate("delete from Movies where pid = 104");
			    System.out.println("deleted = "+ rows);
			    ResultSet rs1 = stmt.executeQuery("Select * from Movies");
			    while(rs1.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
}
}
