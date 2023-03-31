package org.tap.enrollment.service.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.entity.course.Course;
import org.tap.enrollment.genericresponse.GenericResponseEntity;
import org.tap.enrollment.repository.course.CourseRepository;

@Service // marked with the @Service annotation, which makes it a service component in Spring framework
@Transactional // enables transaction management for this class
public class CourseServiceImpl implements CourseService {
	
	/*
	 * This is a field declaration that injects an instance of CourseRepository class
	 *  using Spring's dependency injection. This field will be used to perform CRUD 
	 *  (Create, Read, Update, Delete) operations on Course entities.
	 */
	@Autowired 
	private CourseRepository courseRepository;
	
	/*
	 * This method takes in a Course object and saves it to the repository using the 
	 * courseRepository.save() method. It then returns the saved Course object.
	 */
	@Override
	public ResponseEntity<?> createCourse(Course course) {
		Optional<Course> courseDb = this.courseRepository.findById(course.getCourseCode());
		if(courseDb.isPresent()) {
			return GenericResponseEntity.forbiddenEntity("This record already exists.");
		}
		else {
			return GenericResponseEntity.createSuccessEntity(courseRepository.save(course));
		}
	}
	
	
	
	/*
	 * This method takes in a Course object and first checks if a Course object with the same courseId already
	 * exists in the repository. If it does, it updates the existing Course object with the values from the input Course
	 * object and saves the changes using courseRepository.save(). It then returns the updated Course object. 
	 * If no Course object with the given courseId exists, it throws a ResourceNotFoundException.
	 */
	@Override
	public ResponseEntity<?> updateCourse(Course course) {
		Optional<Course> courseDb = this.courseRepository.findById(course.getCourseCode());
		if(courseDb.isPresent()) {
			Course courseUpdate = courseDb.get();
			courseUpdate.setCourseCode(course.getCourseCode());
			courseUpdate.setCourseDescription(course.getCourseDescription());
			courseRepository.save(courseUpdate);
			return GenericResponseEntity.createSuccessEntity(courseUpdate);
		}
		else {
			return GenericResponseEntity.notFoundEntity("Record not found with course code : " + course.getCourseCode());
		}
	}
	
	/*
	 * This method retrieves all Course objects from the repository using the courseRepository.findAll()
	 * method and returns them in a list.
	 */
	@Override
	public ResponseEntity<?> getAllCourse() {
		List<Course> courseDb = this.courseRepository.findAll();
		
		if(courseDb.isEmpty()) {
			return GenericResponseEntity.notFoundEntity("There are no records found in this table.");
		}else {
			return GenericResponseEntity.createSuccessEntity(courseRepository.findAll());
		}
	}
	
	/*
	 * This method retrieves a Course object from the repository with the given courseId
	 * using the courseRepository.findById() method. If a Course object is found, it is returned. 
	 */
	
	@Override
	public ResponseEntity<?> getCourseByCode(String courseCode) {
		Optional<Course> courseDb = this.courseRepository.findById(courseCode);
		
		if(courseDb.isPresent()) {
			return GenericResponseEntity.createSuccessEntity(courseDb.get());
		}else {
			return GenericResponseEntity.notFoundEntity("Record not found with course code : " + courseCode);
}
	}
	
	/*
	 * This method deletes the Course object with the given id from the repository using the 
	 * courseRepository.delete() method. If a Course object with the given id exists, it is deleted. 
	 */
	@Override
	public void deleteCourse(String courseCode) {
		Optional<Course> courseDb = this.courseRepository.findById(courseCode);
		
		if(courseDb.isPresent()) {
			this.courseRepository.delete(courseDb.get());
		}else {
			GenericResponseEntity.notFoundEntity("Record not found with course code : " + courseCode);
		}
	}

	@Override
	public ResponseEntity<?>  findByCourseDescription(String courseDescription) {
		Optional<Course> courseDb = this.courseRepository.findByCourseDescription(courseDescription);
		
		if(courseDb.isPresent()) {
			return GenericResponseEntity.createSuccessEntity(courseDb.get());
		}else {
			return GenericResponseEntity.notFoundEntity("Record not found with course description : " + courseDescription);
		}
	}









	


}
