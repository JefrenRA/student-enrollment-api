package org.tap.enrollment.controller.course;

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
import org.tap.enrollment.entity.course.Course;
import org.tap.enrollment.model.request.course.CourseInfoRequest;
import org.tap.enrollment.service.course.CourseService;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that 
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/enrollment")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class CourseController {
	
	//This annotation indicates that Spring should inject a CourseService object into the class at runtime
	@Autowired 
	private CourseService courseService;
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/get-all-course endpoint and 
	 * returns a list of all courses in the system.
	 */
	@GetMapping("/get-all-course")  
	public ResponseEntity<?> getAllCourseInfo(){
		return courseService.getAllCourse();
	}
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/get-course/{courseCode} endpoint and 
	 * returns the course with the specified id.
	 */
	@GetMapping("/get-course/{courseCode}") 
	public ResponseEntity<?> getCoursetByCode(@PathVariable String courseCode){
		return courseService.getCourseByCode(courseCode);
	}
	
	/*
	 * This method handles HTTP GET requests to the /enrollment/get-course/{courseDescription} endpoint and 
	 * returns the course with the specified id.
	 */
	@GetMapping("/get-course/{courseDescription}") 
	public ResponseEntity<?> getCoursetByDescription(@PathVariable String courseDescription){
		return courseService.findByCourseDescription(courseDescription);
	}
	
	
	/*
	 * This method handles HTTP POST requests to the /enrollment/create-course endpoint and creates a new 
	 * course in the system based on the information provided in the request body.
	 */
	@PostMapping("/create-course") 
	public ResponseEntity<?> createCourse(@Valid @RequestBody CourseInfoRequest courseInfo){
		
		Course course = new Course();
		course.setCourseCode(courseInfo.getCourseCode());
		course.setCourseDescription(courseInfo.getCourseDescription());
		
		return courseService.createCourse(course);
	}
	
	/*
	 * This method handles HTTP PUT requests to the /enrollment/update-course/{courseCode} endpoint and updates 
	 * the course with the specified id based on the information provided in the request body.
	 */
	@PutMapping("/update-course/{courseCode}") 
	public ResponseEntity<?> updateCourse(@PathVariable String courseCode, @RequestBody Course course){
		course.setCourseCode(courseCode);
		return courseService.updateCourse(course);
	}
	
	/*
	 * This method handles HTTP DELETE requests to the /enrollment/delete-course/{courseCode} endpoint and
	 *  deletes the course with the specified id.
	 */
	@DeleteMapping("/delete-course/{courseCode}")
	public HttpStatus deleteCourse(@PathVariable String courseCode) {
		courseService.deleteCourse(courseCode);
		return HttpStatus.OK;
	}
	
	/*
	 * Each endpoint returns a ResponseEntity object, which is a container for the HTTP response 
	 * that allows you to set the status code, headers, and body of the response. 
	 */
}
