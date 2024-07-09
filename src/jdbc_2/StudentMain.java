package jdbc_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentMain{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		boolean b=true;
		System.out.println("welcome for using CRUD opearations");
		while(b) {
			System.out.println("1:insert\n2:update\n3:delete\n4:fetch\n5:exit");
			System.out.println("enter the option:");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("inseted success");
				break;
			case 2:
				System.out.println("enter the updated name:");
				String name=sc.next();
				System.out.println("enter the name:");
				String name1=sc.next();
				PreparedStatement ps = con.prepareStatement("update table1 set name=? where name=?");
				ps.setString(1,name);
				ps.setString(2, name1);
				int r = ps.executeUpdate();
				System.out.println("updated succesfully "+r+" row");
				break;
			case 3:
				System.out.println("enter the deleted name:");
				String name11=sc.next();
				PreparedStatement pss = con.prepareStatement("delete from table1 where name=?");
				pss.setString(1,name11);
				int res = pss.executeUpdate();
				System.out.println("deleted succesfully "+ res+" row");
			case 4:
				System.out.println("ente the email:");
				String email=sc.next();
				System.out.println("enter the phone:");
				int phno=sc.nextInt();
				PreparedStatement ps1 = con.prepareStatement("select * from table1 where email=? and phone=?");
				ps1.setString(1,email);
				ps1.setInt(2, phno);
				ResultSet re = ps1.executeQuery();
				while(re.next()) {
					int slno = re.getInt(1);
					 String nam=re.getString("name");
					String mail=re.getString("email");
					int phnum=re.getInt(5);
					System.out.println(slno+" "+nam+" "+mail+" "+phnum);
				}
				System.out.println("fetched sucess");
				break;
			case 5:
				b=false;
				break;
			default:
				System.out.println("enter the correct value");
			}
		}
		System.out.println("Tnx for using application.");
	}
}
