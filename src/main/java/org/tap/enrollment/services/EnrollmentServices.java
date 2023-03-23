package org.tap.enrollment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tap.enrollment.entity.Student;
import org.tap.enrollment.repository.StudentRepository;

@Service
public class EnrollmentServices {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student enrollStudent(Student student){
		return studentRepository.save(student);
	}

}
