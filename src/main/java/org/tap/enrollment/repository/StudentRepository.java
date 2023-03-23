package org.tap.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tap.enrollment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
