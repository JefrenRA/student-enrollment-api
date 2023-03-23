package org.tap.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long>{

}
