package jdbc_2;

import java.sql.SQLException;
import java.util.Scanner;
import jdbc_2.dao.StudentCrud;
import jdbc_2.dto.Student;
public class StudentMain111 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentCrud crud=new StudentCrud();
		try {
			crud.createStudent();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		System.out.println("welcome for using CRUD opearations");
		do {
			System.out.println("1:insert\n2:update\n3:delete\n4:fetch\n5:exit");
			System.out.println("enter the option:");
			int option=sc.nextInt();
			switch(option){
			case 1:
				System.out.println("enter the id:");
				int id=sc.nextInt();
				System.out.println("enter the name:");
				String name=sc.next();
				System.out.println("enter the email:");
				String email=sc.next();
				System.out.println("enter the phno:");
				long phno=sc.nextLong();
				System.out.println("enter the PWD:");
				String pwd=sc.next();
				System.out.println("enter the marks:");
				double marks=sc.nextDouble();
				Student stud=new Student(id, name,email, phno,pwd, marks);
				crud.saveStudent(stud);
				System.out.println("inseted success");
				break;			
			case 2:
				System.out.println("enter the updatename:");
				String name1=sc.next();
				System.out.println("enter the id:");
				int id1=sc.nextInt();
				Student stud1=new Student(name1,id1);
				crud.updateStudent(stud1);
				System.out.println("updated success");
				break;
			case 3:
				System.out.println("enter the id:");
				int id2=sc.nextInt();
				Student stud2=new Student(id2);
				crud.deleteStudent(stud2);
				System.out.println("deleted success");
				break;
			case 4:{
				System.out.println("enter the table name:");
				String table=sc.next();
				Student stud3=new Student(table);
				crud.fetchStudent(stud3);
				System.out.println("fetch success");
			}
				break;
			case 5:
				b=false;
				break;
			default:
				System.out.println("enter the correct value");
			}
		}while(b);
		System.out.println("Tnx for using application.");
	}
}

