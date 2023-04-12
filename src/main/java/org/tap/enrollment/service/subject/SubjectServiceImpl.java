package org.tap.enrollment.service.subject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.entity.subject.Subject;
import org.tap.enrollment.genericresponse.GenericResponseEntity;
import org.tap.enrollment.repository.subject.SubjectRepository;

@Service 				// This is a class marked with the @Service annotation, which makes it a service component in Spring framework
@Transactional		 	// This annotation enables transaction management for this class
public class SubjectServiceImpl implements SubjectService {

	/*
	 * This is a field declaration that injects an instance of SubjectRepository class
	 *  using Spring's dependency injection. This field will be used to perform CRUD
	 *  (Create, Read, Update, Delete) operations on Subject entities.
	 */
	@Autowired
	private SubjectRepository subjectRepository;

	/*
	 * This method takes in a Subject object and saves it to the repository using the
	 * subjectRepository.save() method. It then returns the saved Subject object.
	 */
	@Override
	public ResponseEntity<?> createSubject(Subject subject) {

		Optional<Subject> subjectDb = this.subjectRepository.findById(subject.getSubjectId());

		if(subjectDb.isPresent()) {
			return GenericResponseEntity.forbiddenEntity("This record already exists.");
		}else {
			return GenericResponseEntity.createSuccessEntity(subjectRepository.save(subject));
		}

	}

	/*
	 * This method takes in a Subject object and first checks if a Subject object with the same subjectId
	 * already exists in the repository. If it does, it updates the existing Subject object with the values
	 * from the input Subject object and saves the changes using subjectRepository.save(). It then returns
	 * the updated Subject object. If no Subject object with the given subjectId exists, it throws a ResourceNotFoundException.
	 */
	@Override
	public ResponseEntity<?> updateSubject(Subject subject) {
		Optional<Subject> subjectDb = this.subjectRepository.findById(subject.getSubjectId());
		if(subjectDb.isPresent()) {
			Subject subjectUpdate = subjectDb.get();
			subjectUpdate.setSubjectId(subject.getSubjectId());
			subjectUpdate.setSubjectCode(subject.getSubjectCode());
			subjectUpdate.setSubjectDescription(subject.getSubjectDescription());

			return GenericResponseEntity.createSuccessEntity(subjectUpdate);
		}
		else {
			return GenericResponseEntity.notFoundEntity("Record not found with course code : " + subject.getSubjectId());
		}
	}

	/*
	 * This method retrieves all Subject objects from the repository using the subjectRepository.findAll()
	 * method and returns them in a list.
	 */
	@Override
	public ResponseEntity<?> getAllSubjectsInfo() {
		List<Subject> subjectDb = this.subjectRepository.findAll();

		if(subjectDb.isEmpty()) {
			return GenericResponseEntity.notFoundEntity("There are no records found in this table.");
		}else {
			return GenericResponseEntity.createSuccessEntity(this.subjectRepository.findAll());
		}
	}

	/*
	 * This method retrieves a Subject object from the repository with the given subjectId
	 * using the subjectRepository.findById() method. If a Subject object is found, it is returned.
	 */
	@Override
	public ResponseEntity<?> getSubjectById(long subjectId) {
		Optional<Subject> subjectDb = this.subjectRepository.findById(subjectId);

		if(subjectDb.isPresent()) {
			 return GenericResponseEntity.createSuccessEntity(subjectDb.get());
		}else {
			return GenericResponseEntity.notFoundEntity("Record not found with course code : " + subjectId);
		}
	}

	/*
	 * This method deletes the Subject object with the given id from the repository using the
	 * subjectRepository.delete() method. If a Subject object with the given id exists, it is deleted.
	 */
	@Override
	public void deleteSubject(long id) {
		Optional<Subject> subjectDb = this.subjectRepository.findById(id);

		if(subjectDb.isPresent()) {
			this.subjectRepository.delete(subjectDb.get());
		}else {
			GenericResponseEntity.notFoundEntity("Record not found with course code : " + id);
		}
	}

}
