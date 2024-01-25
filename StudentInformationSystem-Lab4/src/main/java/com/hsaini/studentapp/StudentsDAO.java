package com.hsaini.studentapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

	public void create(Students student) {
		System.out.println(student.getFname());
		//we use prepared statements, Q: why?
		String sql = "INSERT INTO students(fname, lname, age) VALUES(?,?,?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getFname());
			pstmt.setString(2, student.getLname());
			pstmt.setInt(3, student.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Students> readAll() {
		String sql = "SELECT id, fname, lname, age FROM students";
		List<Students> students = new ArrayList<>();
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Students student = new Students();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setAge(rs.getInt("age"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return students;
	}
}
