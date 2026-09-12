package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {
	public static void main(String args[]) {

		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/hfdb";
		String USER = "root";
		String PASSWORD = "root123";

		Connection con = null;
		PreparedStatement ps = null;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement("Insert INTO student values(?,?,?)");
			
			System.out.println("Enter Roll Number :");
			int rno = Integer.parseInt(br.readLine());
			System.out.println("Enter Name :");
			String name = br.readLine();
			System.out.println("Enter Percentage :");
			double per = Double.parseDouble(br.readLine());
			
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3, per);
			
			int val = ps.executeUpdate();
			if (val >= 1) {
				System.out.println("Student is saved Successfully!! ");
			} else {
				System.out.println("Unable to save Student");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
