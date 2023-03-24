package org.tap.enrollment.student.service;

import java.util.List;

import org.tap.enrollment.student.entity.Student;

public interface StudentService {
	Student createStudent(Student student);
	Student updateStudent(Student student);
	List<Student> getAllStudentsInfo();
	Student getStudentById(long studentId);
	void deleteStudent(long id);
}
