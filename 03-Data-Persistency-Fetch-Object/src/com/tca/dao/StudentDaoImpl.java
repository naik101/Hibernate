package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

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
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		} finally {
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

	@Override
	public List<Student> getAllStudent() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/hfdb";
		String USER = "root";
		String PASSWORD = "root123";

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement("SELECT *FROM student");

			List<Student> l = new ArrayList<>();

			rs = ps.executeQuery();
			while (rs.next()) {
				int rno = rs.getInt("rno");
				String name = rs.getString("name");
				double per = rs.getDouble("per");

				Student s = new Student();
				s.setRno(rno);
				s.setName(name);
				s.setPer(per);
				l.add(s);
			}
			if (l.isEmpty()) {
				return null;
			}

			return l;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

}
