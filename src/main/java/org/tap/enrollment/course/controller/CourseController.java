package org.tap.enrollment.course.controller;

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
import org.tap.enrollment.course.entity.Course;
import org.tap.enrollment.course.model.request.CourseInfoRequest;
import org.tap.enrollment.course.service.CourseService;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that 
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/enrollment")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class CourseController {
	
	//This annotation indicates that Spring should inject a CourseService object into the class at runtime
	@Autowired 
	private CourseService courseService;
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/course endpoint and 
	 * returns a list of all courses in the system.
	 */
	@GetMapping("/course")  
	public ResponseEntity<List<Course>> getAllCourseInfo(){
		return ResponseEntity.ok().body(courseService.getAllCourseInfo());
	}
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/course/{id} endpoint and 
	 * returns the course with the specified id.
	 */
	@GetMapping("/course/{id}") 
	public ResponseEntity<Course> getCoursetById(@PathVariable long id){
		return ResponseEntity.ok().body(courseService.getCourseById(id));
	}
	
	/*
	 * This method handles HTTP POST requests to the /enrollment/course endpoint and creates a new 
	 * course in the system based on the information provided in the request body.
	 */
	@PostMapping("/course") 
	public ResponseEntity<Course> createCourse(@Valid @RequestBody CourseInfoRequest courseInfo){
		
		Course course = new Course();
		course.setCourseCode(courseInfo.getCourseCode());
		course.setCourseDescription(courseInfo.getCourseDescription());
		
		return ResponseEntity.ok().body(courseService.createCourse(course));
	}
	
	/*
	 * This method handles HTTP PUT requests to the /enrollment/course/{id}  endpoint and updates 
	 * the course with the specified id based on the information provided in the request body.
	 */
	@PutMapping("/course/{id}") 
	public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course course){
		course.setCourseId(id);
		return ResponseEntity.ok().body(courseService.updateCourse(course));
	}
	
	/*
	 * This method handles HTTP DELETE requests to the /enrollment/course/{id} endpoint and
	 *  deletes the course with the specified id.
	 */
	@DeleteMapping("/course/{id}")
	public HttpStatus deleteCourse(@PathVariable long id) {
		courseService.deleteCourse(id);
		return HttpStatus.OK;
	}
	
	/*
	 * Each endpoint returns a ResponseEntity object, which is a container for the HTTP response 
	 * that allows you to set the status code, headers, and body of the response. 
	 */
}
