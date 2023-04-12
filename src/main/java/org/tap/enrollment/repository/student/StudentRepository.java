package org.tap.enrollment.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.entity.student.Student;

@Repository // indicate that this interface is a repository. The repository is responsible for managing and providing access to data.
public interface StudentRepository extends JpaRepository<Student , Long>{

	/*
	 * This defines the StudentRepository interface that extends the JpaRepository
	 * interface, which provides all the basic CRUD (Create, Read, Update, Delete)
	 * operations for the Student entity
	 */
}


	/*
	 * With this repository, Spring Data JPA will automatically generate SQL queries and execute them against the
	 * underlying database based on method names and entity attributes, without requiring the developer to write
	 * SQL queries manually. This saves a lot of time and effort when working with databases.
	 */