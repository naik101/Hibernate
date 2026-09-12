package com.tca;

import java.util.List;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entities.Student;

public class App {
   public static void main(String args[])
   {
	   StudentDao studentDao = new StudentDaoImpl();
	   List<Student> l = studentDao.getAllStudent();
	   
	   if(l.isEmpty())
	   {
		  System.out.println("Students Table is Empty");   
	   }
	   
	   for(Student s:l)
	   {
		   System.out.println("----".repeat(7));
		   System.out.println("Student Roll Number: "+s.getRno());
		   System.out.println("Student Name: "+s.getName());
		   System.out.println("Student Per: "+s.getPer());
		   System.out.println("----".repeat(7));

	   }
	
	   
   }
}
