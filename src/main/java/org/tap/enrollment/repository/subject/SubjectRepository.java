package org.tap.enrollment.repository.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.entity.subject.Subject;

@Repository // indicate that this interface is a repository. The repository is responsible for managing and providing access to data.
public interface SubjectRepository extends JpaRepository<Subject , Long>{
	
	/*
	 * This defines the SubjectRepository interface that extends the JpaRepository 
	 * interface, which provides all the basic CRUD (Create, Read, Update, Delete) 
	 * operations for the Subject entity
	 */
}


	/*
	 * With this repository, Spring Data JPA will automatically generate SQL queries and execute them against the 
	 * underlying database based on method names and entity attributes, without requiring the developer to write 
	 * SQL queries manually. This saves a lot of time and effort when working with databases. 
	 */