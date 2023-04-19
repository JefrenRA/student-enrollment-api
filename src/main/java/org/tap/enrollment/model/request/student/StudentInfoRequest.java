package org.tap.enrollment.model.request.student;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.tap.enrollment.entity.course.Course;
import org.tap.enrollment.entity.subject.Subject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //These annotations generates getter and setter methods for the fields of the class automatically
public class StudentInfoRequest implements Serializable{

	/*
	 * The class implements the Serializable interface, which allows objects of this class to be serialized
	 * and deserialized, i.e., converted to and from a stream of bytes for storage or transmission
	 */

	private static final long serialVersionUID = -411404243542092196L;

	@JsonProperty(value = "StudentId")
	private Long studentId;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "Surname")
	private String surName;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "Firstname")
	private String firstName;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "Address")
	private String address;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "DateOfBirth")
	private String dateOfBirth;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "Gender")
	private String gender;

	@JsonProperty(value = "Course")
	private Course course;

	@JsonProperty(value = "Subject")
	private List<Subject> subject;


	/*
	 * Overall, this code file defines a class with six string properties that can be serialized
	 * and deserialized to and from JSON, with the help of Jackson annotations.
	 */
}
