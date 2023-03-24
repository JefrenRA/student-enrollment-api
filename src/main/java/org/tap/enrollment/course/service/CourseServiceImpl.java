package org.tap.enrollment.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.course.entity.Course;
import org.tap.enrollment.course.repository.CourseRepository;
import org.tap.enrollment.exception.ResourceNotFoundException;

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
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	/*
	 * This method takes in a Course object and first checks if a Course object with the same courseId already
	 * exists in the repository. If it does, it updates the existing Course object with the values from the input Course
	 * object and saves the changes using courseRepository.save(). It then returns the updated Course object. 
	 * If no Course object with the given courseId exists, it throws a ResourceNotFoundException.
	 */
	@Override
	public Course updateCourse(Course course) {
		Optional<Course> courseDb = this.courseRepository.findById(course.getCourseId());
		if(courseDb.isPresent()) {
			Course courseUpdate = courseDb.get();
			courseUpdate.setCourseId(course.getCourseId());
			courseUpdate.setCourseCode(course.getCourseCode());
			courseUpdate.setCourseDescription(course.getCourseDescription());
			courseRepository.save(courseUpdate);
			return courseUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + course.getCourseId());
		}
	}
	
	/*
	 * This method retrieves all Course objects from the repository using the courseRepository.findAll()
	 * method and returns them in a list.
	 */
	@Override
	public List<Course> getAllCourseInfo() {
		return this.courseRepository.findAll();
	}
	
	/*
	 * This method retrieves a Course object from the repository with the given courseId
	 * using the courseRepository.findById() method. If a Course object is found, it is returned. 
	 */
	@Override
	public Course getCourseById(long courseId) {
		Optional<Course> courseDb = this.courseRepository.findById(courseId);
		
		if(courseDb.isPresent()) {
			return courseDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + courseId);
		}
	}
	
	/*
	 * This method deletes the Course object with the given id from the repository using the 
	 * courseRepository.delete() method. If a Course object with the given id exists, it is deleted. 
	 */
	@Override
	public void deleteCourse(long id) {
		Optional<Course> courseDb = this.courseRepository.findById(id);
		
		if(courseDb.isPresent()) {
			this.courseRepository.delete(courseDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

}
