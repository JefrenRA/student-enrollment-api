package org.tap.enrollment.repository.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.entity.course.Course;

@Repository // indicate that this interface is a repository. The repository is responsible for managing and providing access to data.
public interface CourseRepository extends JpaRepository<Course , String> {

	/*
	 * This defines the CourseRepository interface that extends the JpaRepository
	 * interface, which provides all the basic CRUD (Create, Read, Update, Delete)
	 * operations for the Course entity
	 */
	Optional<Course> findByCourseDescription(@Param("courseDescription")String courseDescription);
}


	/*
	 * With this repository, Spring Data JPA will automatically generate SQL queries and execute them against the
	 * underlying database based on method names and entity attributes, without requiring the developer to write
	 * SQL queries manually. This saves a lot of time and effort when working with databases.
	 *
	 */