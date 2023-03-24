package org.tap.enrollment.student.model.request;

import java.io.Serializable;

import javax.persistence.OneToOne;

import org.tap.enrollment.course.entity.Course;

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
	
	@JsonProperty(value = "Surname", required = true)
	private String surName;
	
	@JsonProperty(value = "Firstname", required = true)
	private String firstName;
	
	@OneToOne 
	@JsonProperty(value = "CourseId", required = true)
	private Course course;
	
	@JsonProperty(value = "Address", required = true)
	private String address;
	
	@JsonProperty(value = "DateOfBirth", required = true)
	private String dateOfBirth;
	
	@JsonProperty(value = "Gender", required = true)
	private String gender;
	
	
	/*
	 * Overall, this code file defines a class with six string properties that can be serialized 
	 * and deserialized to and from JSON, with the help of Jackson annotations.
	 */
}
