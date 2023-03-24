package org.tap.enrollment.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.course.entity.Course;

@Repository // indicate that this interface is a repository. The repository is responsible for managing and providing access to data.
public interface CourseRepository extends JpaRepository<Course , Long> {
	
	/*
	 * This defines the CourseRepository interface that extends the JpaRepository 
	 * interface, which provides all the basic CRUD (Create, Read, Update, Delete) 
	 * operations for the Course entity
	 */
}


	/*
	 * With this repository, Spring Data JPA will automatically generate SQL queries and execute them against the 
	 * underlying database based on method names and entity attributes, without requiring the developer to write 
	 * SQL queries manually. This saves a lot of time and effort when working with databases.
	 * 
	 */