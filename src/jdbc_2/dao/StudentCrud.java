package jdbc_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import jdbc_2.dto.Student;
public class StudentCrud {
	Scanner sc=new Scanner(System.in);
	public void createStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase?createDatabaseIfNotExist=true","root","root");
		Statement s = con.createStatement();
		s.execute("create table if not exists student(id int primary key,name varchar(45),email varchar(45),phone bigint,pwd varchar(45),marks double)");
		s.close();
		con.close();
		System.out.println("table created");
	}
	public void saveStudent(Student stud) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			ps.setInt(1, stud.getId());
			ps.setString(2, stud.getName());
			ps.setString(3, stud.getEmail());
			ps.setLong(4, stud.getPhone());
			ps.setString(5, stud.getPwd());
			ps.setDouble(6, stud.getMarks());
			ps.execute();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateStudent(Student stud) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase", "root", "root");
		PreparedStatement ps = con.prepareStatement("update student set name=? where id=?");		
		ps.setString(1,stud.getName());
		ps.setInt(2,stud.getId());
		ps.execute();
		ps.close();
		con.close();
	}
	public void deleteStudent(Student stud) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase", "root", "root");
		PreparedStatement ps = con.prepareStatement("delete from student where id=?");	
		ps.setInt(1,stud.getId());
		ps.execute();
		ps.close();
		con.close();
	}
	public void fetchStudent(Student stud) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from student");	
		ResultSet res= ps.executeQuery();
		while(res.next()) {
			int id=res.getInt("id");
			String name=res.getString(2);
			String email=res.getString(3);
			long phone=res.getLong(4);
			String pwd=res.getString(5);
			double mark=res.getDouble(6);
			System.out.println(id+":"+name+":"+email+":"+phone+":"+pwd+":"+mark);
		}
		ps.close();
		con.close();
	}
}
