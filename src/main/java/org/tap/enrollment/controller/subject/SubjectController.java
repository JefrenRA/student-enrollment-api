package org.tap.enrollment.controller.subject;

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
import org.tap.enrollment.entity.subject.Subject;
import org.tap.enrollment.model.request.subject.SubjectInfoRequest;
import org.tap.enrollment.service.subject.SubjectService;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/subject-enrollment")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class SubjectController {

	//This annotation indicates that Spring should inject a StudentService object into the class at runtime
	@Autowired
	private SubjectService subjectService;

	/*
	 * This method handles HTTP GET requests to the /enrollment/get-all-subjects endpoint and returns a list
	 * of all subjects in the system.
	 */
	@GetMapping("/get-all-subjects")
	public ResponseEntity<?> getAllSubjectInfo(){
		return subjectService.getAllSubjectsInfo();
	}

	/*
	 * This method handles HTTP GET requests to the /enrollment/get-subject/{id} endpoint and
	 * returns the subject with the specified id.
	 */
	@GetMapping("/get-subject/{id}")
	public ResponseEntity<?> getSubjectById(@PathVariable long id){
		return subjectService.getSubjectById(id);
	}

	/*
	 * This method handles HTTP POST requests to the /enrollment/create-subject endpoint and creates a new
	 * subject in the system based on the information provided in the request body.
	 */
	@PostMapping("/create-subject")
	public ResponseEntity<?> createSubject(@Valid @RequestBody SubjectInfoRequest subjectInfo){

		Subject subject = new Subject();
		subject.setSubjectCode(subjectInfo.getSubjectCode());
		subject.setSubjectDescription(subjectInfo.getDescription());

		return subjectService.createSubject(subject);
	}

	/*
	 * This method handles HTTP PUT requests to the /enrollment/update-subject/{id} endpoint and updates the
	 * subject with the specified id based on the information provided in the request body.
	 */
	@PutMapping("/update-subject/{id}")
	public ResponseEntity<?> updateSubject(@PathVariable long id, @RequestBody Subject subject){
		subject.setSubjectId(id);
		return subjectService.updateSubject(subject);
	}

	/*
	 * This method handles HTTP DELETE requests to the /enrollment/delete-subject/{id} endpoint and deletes the
	 * subject with the specified id.
	 */
	@DeleteMapping("/delete-subject/{id}")
	public HttpStatus deleteSubject(@PathVariable long id) {
		subjectService.deleteSubject(id);
		return HttpStatus.OK;
	}
}

	/*
	 * Each endpoint returns a ResponseEntity object, which is a container for the HTTP response
	 * that allows you to set the status code, headers, and body of the response.
	 */
