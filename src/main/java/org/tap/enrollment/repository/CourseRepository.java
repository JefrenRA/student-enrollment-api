package org.tap.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long> {

}
