package org.tap.enrollment.service.course;

import java.util.List;

import org.tap.enrollment.model.Course;

public interface CourseService {
	Course createCourse(Course course);
	Course updateCourse(Course course);
	List<Course> getAllCourseInfo();
	Course getCourseById(long courseId);
	void deleteCourse(long id);
}