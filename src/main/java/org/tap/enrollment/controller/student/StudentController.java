package org.tap.enrollment.controller.student;

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
import org.tap.enrollment.entity.student.Student;
import org.tap.enrollment.model.request.student.StudentInfoRequest;
import org.tap.enrollment.service.student.StudentService;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that 
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/enrollment")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class StudentController {
	
	//This annotation indicates that Spring should inject a StudentService object into the class at runtime
	@Autowired
	private StudentService studentService;
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/get-all-students endpoint and returns a list 
	 * of all students in the system.
	 */
	@GetMapping("/get-all-students")
	public ResponseEntity<?> getAllStudentsInfo(){
		return studentService.getAllStudentsInfo();
	}
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/get-student/{id} endpoint and 
	 * returns the student with the specified id.
	 */
	@GetMapping("/get-student/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable long id){
		return studentService.getStudentById(id);
	}
	
	/*
	 * This method handles HTTP POST requests to the /enrollment/create-student endpoint and creates a new 
	 * student in the system based on the information provided in the request body.
	 */
	@PostMapping("/create-student")
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentInfoRequest studentInfo){
		
		Student student = new Student();
		student.setStudentId(studentInfo.getStudentId());
		student.setSurName(studentInfo.getSurName());
		student.setFirstName(studentInfo.getFirstName());
		student.setAddress(studentInfo.getAddress());
		student.setDateOfBirth(studentInfo.getDateOfBirth());
		student.setGender(studentInfo.getGender());
		student.setCourse(studentInfo.getCourse());
		student.setSubject(studentInfo.getSubject());
		
		return studentService.createStudent(student);
	}
	
	/*
	 * This method handles HTTP PUT requests to the /enrollment/update-student/{id} endpoint and updates the
	 * student with the specified id based on the information provided in the request body.
	 */
	@PutMapping("/update-student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody Student student){
		student.setStudentId(id);
		return studentService.updateStudent(student);
	}

	/*
	 * This method handles HTTP DELETE requests to the /enrollment/delete-student/{id} endpoint and deletes the
	 * student with the specified id.
	 */
	@DeleteMapping("/delete-student/{id}")
	public HttpStatus deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
}

	/*
	 * Each endpoint returns a ResponseEntity object, which is a container for the HTTP response 
	 * that allows you to set the status code, headers, and body of the response. 
	 */
