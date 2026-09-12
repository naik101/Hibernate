package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao {
	public abstract String save(Student s); 
    public abstract List<Student> getAllStudent();
}
