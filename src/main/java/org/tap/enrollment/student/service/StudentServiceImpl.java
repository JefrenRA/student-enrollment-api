package org.tap.enrollment.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.exception.ResourceNotFoundException;
import org.tap.enrollment.student.entity.Student;
import org.tap.enrollment.student.repository.StudentRepository;

@Service 				// This is a class marked with the @Service annotation, which makes it a service component in Spring framework
@Transactional		 	// This annotation enables transaction management for this class
public class StudentServiceImpl implements StudentService {
	
	/*
	 * This is a field declaration that injects an instance of StudentRepository class
	 *  using Spring's dependency injection. This field will be used to perform CRUD 
	 *  (Create, Read, Update, Delete) operations on Student entities.
	 */
	@Autowired 
	private StudentRepository studentRepository;
	
	/*
	 * This method takes in a Student object and saves it to the repository using the 
	 * studentRepository.save() method. It then returns the saved Student object.
	 */
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	/*
	 * This method takes in a Student object and first checks if a Student object with the same studentId 
	 * already exists in the repository. If it does, it updates the existing Student object with the values 
	 * from the input Student object and saves the changes using studentRepository.save(). It then returns
	 * the updated Student object. If no Student object with the given studentId exists, it throws a ResourceNotFoundException.
	 */
	@Override
	public Student updateStudent(Student student) {
		Optional<Student> studentDb = this.studentRepository.findById(student.getStudentId());
		if(studentDb.isPresent()) {
			Student studentUpdate = studentDb.get();
			studentUpdate.setStudentId(student.getStudentId());
			studentUpdate.setFirstName(student.getFirstName());
			studentUpdate.setSurName(student.getSurName());
			studentUpdate.setDateOfBirth(student.getDateOfBirth());
			studentUpdate.setAddress(student.getAddress());
			studentUpdate.setCourse(student.getCourse());
			studentUpdate.setGender(student.getGender());
			studentRepository.save(studentUpdate);
			return studentUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + student.getStudentId());
		}
	}

	/*
	 * This method retrieves all Student objects from the repository using the studentRepository.findAll()
	 * method and returns them in a list.
	 */
	@Override
	public List<Student> getAllStudentsInfo() {
		return this.studentRepository.findAll();
	}

	/*
	 * This method retrieves a Student object from the repository with the given studentId
	 * using the studentRepository.findById() method. If a Student object is found, it is returned. 
	 */
	@Override
	public Student getStudentById(long studentId) {
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		
		if(studentDb.isPresent()) {
			return studentDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + studentId);
		}
	}

	/*
	 * This method deletes the Student object with the given id from the repository using the 
	 * studentRepository.delete() method. If a Student object with the given id exists, it is deleted. 
	 */
	@Override
	public void deleteStudent(long id) {
		Optional<Student> studentDb = this.studentRepository.findById(id);
		
		if(studentDb.isPresent()) {
			this.studentRepository.delete(studentDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

}
