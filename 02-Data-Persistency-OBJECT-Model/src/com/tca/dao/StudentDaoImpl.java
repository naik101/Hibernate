package com.tca.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tca.entiites.Student;

public class StudentDaoImpl implements StudentDao{

	
	@Override
	public String save(Student s) {

	    Connection con = null;
	    PreparedStatement ps = null;

	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String URL = "jdbc:mysql://localhost:3306/hfdb";
	    String USER = "root";
	    String PASSWORD = "root123";

	    try {
	        Class.forName(DRIVER);

	        con = DriverManager.getConnection(URL, USER, PASSWORD);

	        ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");

	        ps.setInt(1, s.getRno());
	        ps.setString(2, s.getName());
	        ps.setDouble(3, s.getPer());

	        int val = ps.executeUpdate();

	        if (val >= 1) {
	            return "Success";
	        } else {
	            return "Failed";
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return "Failed";
	    }
	    finally {
	        try {
	            if (ps != null)
	                ps.close();

	            if (con != null)
	                con.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
