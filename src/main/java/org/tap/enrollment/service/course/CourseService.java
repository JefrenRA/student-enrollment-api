package org.tap.enrollment.service.course;

import org.springframework.http.ResponseEntity;
import org.tap.enrollment.entity.course.Course;

public interface CourseService {
	public void deleteCourse(String courseCode);
	ResponseEntity<?> getAllCourse();
	ResponseEntity<?> createCourse(Course course);
	ResponseEntity<?> updateCourse(Course course);
	ResponseEntity<?> getCourseByCode( String courseCode);
	ResponseEntity<?> findByCourseDescription(String courseDescription);
}
