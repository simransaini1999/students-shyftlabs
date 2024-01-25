package com.hsaini.studentapp;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
@Path("/students")
public class StudentController {
	private StudentDAO studentDAO = new StudentDAO();
	private Student students = new Student();
	
	
	@GET
	@Path("/allstudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		return studentDAO.readAll();
	}
	
//	@GET
//	@Path("/{age}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Student> getAllStudents2() {
//		return studentDAO.readAll1();
//	}
	
	@GET
	@Path("/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getAllStudents3(int age) {
		return studentDAO.read2(age);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(Student student) {
		studentDAO.create(student);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent(@QueryParam("age") int age, @QueryParam("age2") int age2) {
		List<Student> student = new ArrayList<>();
		student = studentDAO.readAll();
		List<Student> ageStudent = new ArrayList<>();
		
		for(int i = 0; i< student.size(); i++) {
			if(student.get(i).getAge() > age && student.get(i).getAge() < age2) {
				ageStudent.add(student.get(i));
			}
		}
		
		return ageStudent;
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateStudent(@PathParam("id") int id, Student student) {
		studentDAO.update(id, student);
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("id") int id) {
		studentDAO.delete(id);
	}
	
	@GET
	@Path("/totalApiCalls")
	public Response getTotalApiCalls(@Context ServletContext ctx) {
		Integer counter = (Integer) ctx.getAttribute("apiCallCounter");
				/* retrieve counter from application context. Hint: You can inject the ServletContext in your REST method, similar to how you inject HttpServletRequest in doGet in the previous labs. */;
		if (counter == null) {
			counter = 0; // Handle the case where the counter attribute is not set
		}
		return Response.ok(counter.toString()).build();
	}
	
}
