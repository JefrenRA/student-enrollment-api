package org.tap.enrollment.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tap.enrollment.student.model.request.StudentInfoRequest;
import org.tap.enrollment.student.service.StudentService;
import org.tap.enrollment.student.entity.Student;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that 
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/enrollment")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class StudentController {
	
	//This annotation indicates that Spring should inject a StudentService object into the class at runtime
	@Autowired
	private StudentService studentService;
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/students endpoint and returns a list 
	 * of all students in the system.
	 */
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsInfo(){
		return ResponseEntity.ok().body(studentService.getAllStudentsInfo() );
	}
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/students/{id} endpoint and 
	 * returns the student with the specified id.
	 */
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	/*
	 * This method handles HTTP POST requests to the /enrollment/students endpoint and creates a new 
	 * student in the system based on the information provided in the request body.
	 */
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentInfoRequest studentInfo){
		
		Student student = new Student();
		student.setSurName(studentInfo.getSurName());
		student.setFirstName(studentInfo.getFirstName());
		student.setAddress(studentInfo.getAddress());
		student.setCourse(studentInfo.getCourse());
		student.setDateOfBirth(studentInfo.getDateOfBirth());
		student.setGender(studentInfo.getGender());
		
		return ResponseEntity.ok().body(studentService.createStudent(student));
	}
	
	/*
	 * This method handles HTTP PUT requests to the /enrollment/students/{id} endpoint and updates the
	 * student with the specified id based on the information provided in the request body.
	 */
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		student.setStudentId(id);
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}

	/*
	 * This method handles HTTP DELETE requests to the /enrollment/student/{id} endpoint and deletes the
	 * student with the specified id.
	 */
	@DeleteMapping("/student/{id}")
	public HttpStatus deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
}

	/*
	 * Each endpoint returns a ResponseEntity object, which is a container for the HTTP response 
	 * that allows you to set the status code, headers, and body of the response. 
	 */
