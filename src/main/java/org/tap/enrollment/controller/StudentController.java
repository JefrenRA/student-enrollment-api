package org.tap.enrollment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.tap.enrollment.entity.Student;
import org.tap.enrollment.model.request.StudentInfoRequest;
import org.tap.enrollment.services.EnrollmentServices;

public class StudentController {
	
	@Autowired
	private EnrollmentServices enrollmentServices;
	
	public ResponseEntity<?> saveStudentInfo(@Valid StudentInfoRequest studentInfo){
		
		Student student = new Student();
		student.setFirstName(studentInfo.getFirstName());
		student.setLastName(studentInfo.getLastName());
		student.setBirthDate(studentInfo.getBirthDate());
		
		return ResponseEntity.ok().body(enrollmentServices.enrollStudent(student));
	}

}
