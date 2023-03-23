package org.tap.enrollment.service.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.exception.ResourceNotFoundException;
import org.tap.enrollment.model.Course;
import org.tap.enrollment.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired 
	private CourseRepository courseRepository;
	
	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

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

	@Override
	public List<Course> getAllCourseInfo() {
		return this.courseRepository.findAll();
	}

	@Override
	public Course getCourseById(long courseId) {
		Optional<Course> courseDb = this.courseRepository.findById(courseId);
		
		if(courseDb.isPresent()) {
			return courseDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + courseId);
		}
	}

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
