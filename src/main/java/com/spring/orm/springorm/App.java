package com.spring.orm.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.spring.orm.springorm.dao.StudentDaoImpl;
import com.spring.orm.springorm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/springorm/config.xml");
        
        
        StudentDaoImpl bean = context.getBean("sd",StudentDaoImpl.class);
        
        //int insert = bean.insert(new Student(3, "naveen", "Blr"));
        
        //System.out.println("Number of records are inserted:"+insert);
        
        //System.out.println("Student:"+bean.getStudent(1));
        
        //System.out.println("Students:"+bean.getStudents());
        
        //bean.delete(1);
        //System.out.println("Students:"+bean.getStudents());
        
//        bean.update(new Student(10,"Sandeep","Pune"));
//        System.out.println("Students:"+bean.getStudents());
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println("*********Welcome to Springboot Application*************");
        System.out.println(" 1:Create Student \n 2:Update student \n 3:Delete Student \n 4:Get single Student details \n 5:Get All Student Details");
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("Enter Your Choice:");
        ch=sc.nextInt();
        
        int id;
        String name,address;
        switch (ch) {
		case 1: System.out.println("Please Enter Student id,Name and Address");
				id=sc.nextInt();
				name=sc.next();
				address=sc.next();
				int insert = bean.insert(new Student(id, name, address));
				System.out.println("id:"+insert+" Has been added to DB");
				System.out.println("Student List\n"+bean.getStudents());
				break;
				
			case 2:
				System.out.println("Please Enter Student id to be updated");
				id=sc.nextInt();
				name=sc.next();
				address=sc.next();
				bean.update(new Student(id, name, address));
				System.out.println("id:" + id + "Has been updated");
				System.out.println("Student List\n" + bean.getStudents());
				break;
				
			case 3:
				System.out.println("Please Enter Student id to be deleted");
				id=sc.nextInt();
				bean.delete(id);
				System.out.println("id:" + id + "Has been deleted");
				System.out.println("Student List\n" + bean.getStudents());
				break;
				
			case 4:
				System.out.println("Please Enter Student id to be ddispalyed");
				id=sc.nextInt();
				Student student = bean.getStudent(id);
				System.out.println("Student Details: " + student);
				break;
				
			case 5:
				System.out.println("Student Details");
				List<Student> students = bean.getStudents();
				System.out.println("Student Details: " + students);
				break;
				
		default:System.out.println("Invalid Choice");
			break;
		}
        
        
        
        
    }
}
