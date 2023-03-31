package org.tap.enrollment.service.student;


import org.springframework.http.ResponseEntity;
import org.tap.enrollment.entity.student.Student;

public interface StudentService {
	ResponseEntity<?> createStudent(Student student);
	ResponseEntity<?> updateStudent(Student student);
	ResponseEntity<?> getAllStudentsInfo();
	ResponseEntity<?> getStudentById(long studentId);
	void deleteStudent(long id);
}
