package org.tap.enrollment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tap.enrollment.model.Course;
import org.tap.enrollment.model.Student;
import org.tap.enrollment.service.course.CourseService;
import org.tap.enrollment.service.student.StudentService;

@RestController
public class StudentEnrollmentController {
	@Autowired // initiate class automatically
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsInfo(){
		return ResponseEntity.ok().body(studentService.getAllStudentsInfo() );
	}
	
	@GetMapping("/students/{id}") //get mapping is used to get data based on url from a specific variable
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	@PostMapping("/students") // post mapping is used to get data based on the request body, recommended for getting sensitive data like username and passwords
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(studentService.createStudent(student));
	}
	
	@PutMapping("/students/{id}") // put mapping is used to insert and update data to database
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		student.setStudentId(id);
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}

	@DeleteMapping("/student/{id}") // delete mapping is used to delete/remove data from database
	public HttpStatus deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getAllCourseInfo(){
		return ResponseEntity.ok().body(courseService.getAllCourseInfo());
	}
	
	@GetMapping("/course/{id}") //get mapping is used to get data based on url from a specific variable
	public ResponseEntity<Course> getCoursetById(@PathVariable long id){
		return ResponseEntity.ok().body(courseService.getCourseById(id));
	}
	
	@PostMapping("/course") // post mapping is used to get data based on the request body, recommended for getting sensitive data like username and passwords
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		return ResponseEntity.ok().body(courseService.createCourse(course));
	}
	
	@PutMapping("/course/{id}") // put mapping is used to insert and update data to database
	public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course course){
		course.setCourseId(id);
		return ResponseEntity.ok().body(courseService.updateCourse(course));
	}

	@DeleteMapping("/course/{id}") // delete mapping is used to delete/remove data from database
	public HttpStatus deleteCourse(@PathVariable long id) {
		courseService.deleteCourse(id);
		return HttpStatus.OK;
	}
}
