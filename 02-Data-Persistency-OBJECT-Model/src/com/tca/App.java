package com.tca;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entiites.Student;

public class App {
	public static void main(String args[]) {
		Student s = new Student();
		s.setRno(102);
		s.setName("BBB");
		s.setPer(98.0);

		StudentDao studentDao = new StudentDaoImpl();
		String status = studentDao.save(s);
        
		if(status.equalsIgnoreCase("Success"))
		{
			System.out.println("Student is saved Suscessfully!!");
		}
		else
		{
			System.out.println("Failed To Save Student");
		}
	}
}
