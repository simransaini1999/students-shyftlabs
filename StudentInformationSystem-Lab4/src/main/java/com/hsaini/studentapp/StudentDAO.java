package com.hsaini.studentapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
	
	public List<Student> readAll() {
		String sql = "SELECT id, name, age, major FROM students";
		List<Student> students = new ArrayList<>();
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setMajor(rs.getString("major"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return students;
	}
	public void create(Student student) {
		//we use prepared statements, Q: why?
		String sql = "INSERT INTO students(name, age, major) VALUES(?,?,?)";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getMajor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Student> readAll1() {
		String sql = "SELECT name FROM students WHERE age >18 && age < 100";
		List<Student> students = new ArrayList<>();
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setMajor(rs.getString("major"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return students;
	}
	
	public Student read(int id) {
		// Use prepared statements
		String sql = "SELECT name, age, major FROM students WHERE id = ?";
		Student student = null;
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// Set the corresponding parameter
			pstmt.setInt(1, id);
			//Execute the query and get the result set
			try (ResultSet rs = pstmt.executeQuery()) {
				//Check if a result was returned
				if (rs.next()) {
					student = new Student();
					//Set the properties of the student object
					student.setId(id);
					student.setName(rs.getString("name"));
					student.setAge(rs.getInt("age"));
					student.setMajor(rs.getString("major"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return student;
	}
	
	public Student read2(int age) {
		// Use prepared statements
		String sql = "SELECT name FROM students WHERE age > 18 AND age < 100";
		Student student = null;
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// Set the corresponding parameter
			pstmt.setInt(1, age);
			//Execute the query and get the result set
			try (ResultSet rs = pstmt.executeQuery()) {
				//Check if a result was returned
				if (rs.next()) {
					student = new Student();
					//Set the properties of the student object
					//student.setId(id);
					student.setName(rs.getString("name"));
					student.setAge(rs.getInt("age"));
					student.setMajor(rs.getString("major"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return student;
	}
	
	public void update(int id, Student student) {
		//use prepared statments
		String sql = "UPDATE students SET name = ?, age = ?, major = ? WHERE id = ?";
						try (Connection conn = DatabaseConnection.connect();
								PreparedStatement pstmt = conn.prepareStatement(sql)) {
							//Set the corresponding parameters
							pstmt.setString(1, student.getName());
							pstmt.setInt(2, student.getAge());
							pstmt.setString(3, student.getMajor());
							pstmt.setInt(4, id);
							//Update the student record
							pstmt.executeUpdate();
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
	}
	public void delete(int id) {
		String sql = "DELETE FROM students WHERE id = ?";
		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			//Set the corresponding parameter
			pstmt.setInt(1, id);
			//Delete the student record
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}