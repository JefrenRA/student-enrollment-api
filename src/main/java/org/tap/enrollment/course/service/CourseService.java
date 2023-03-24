package org.tap.enrollment.course.service;

import java.util.List;

import org.tap.enrollment.course.entity.Course;

public interface CourseService {
	Course createCourse(Course course);
	Course updateCourse(Course course);
	List<Course> getAllCourseInfo();
	Course getCourseById(long courseId);
	void deleteCourse(long id);
}
