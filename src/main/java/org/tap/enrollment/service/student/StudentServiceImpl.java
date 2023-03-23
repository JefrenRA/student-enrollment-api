package org.tap.enrollment.service.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.exception.ResourceNotFoundException;
import org.tap.enrollment.model.Student;
import org.tap.enrollment.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired 
	private StudentRepository studentRepository;
	
	
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

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

	@Override
	public List<Student> getAllStudentsInfo() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long studentId) {
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		
		if(studentDb.isPresent()) {
			return studentDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + studentId);
		}
	}

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
