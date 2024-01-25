package com.hsaini.studentapp;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/students")

public class StudentsController {
	private StudentsDAO studentsDAO = new StudentsDAO();
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(Students student) {
		studentsDAO.create(student);
	}
	
	@GET
	@Path("/allstudent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Students> getAllStudents() {
		return studentsDAO.readAll();
	}
}
