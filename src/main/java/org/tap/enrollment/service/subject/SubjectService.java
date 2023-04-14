package org.tap.enrollment.service.subject;

import org.springframework.http.ResponseEntity;
import org.tap.enrollment.entity.subject.Subject;

public interface SubjectService {
	ResponseEntity<?> createSubject(Subject subject);
	ResponseEntity<?> updateSubject(Subject subject);
	ResponseEntity<?> getAllSubjectsInfo();
	ResponseEntity<?> getSubjectById(long subjectId);
	void deleteSubject(long id);
}
