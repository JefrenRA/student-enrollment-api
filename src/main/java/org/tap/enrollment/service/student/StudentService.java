package org.tap.enrollment.service.student;

import java.util.List;

import org.tap.enrollment.model.Student;

public interface StudentService {
	Student createStudent(Student student);
	Student updateStudent(Student student);
	List<Student> getAllStudentsInfo();
	Student getStudentById(long studentId);
	void deleteStudent(long id);
}
