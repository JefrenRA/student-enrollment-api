package org.tap.enrollment.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.tap.enrollment.course.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 											// This annotation indicates that this class maps to a database table
@Table(name="Student") 								// This annotation specifies the name of the table
@AllArgsConstructor     							// These annotations generate constructors with all arguments and no arguments, respectively. 
@NoArgsConstructor      							// It further reduce code and simplify object instantiation.
@Getter
@Setter                 							// These annotations generates getter and setter methods for the fields of the class automatically
public class Student {
	@Id                                             // This annotation indicates that the studentId field is the primary key for the table
	@GeneratedValue(strategy = GenerationType.AUTO) // This annotation specifies that the database should generate the value for the primary key automatically
	private Long studentId;
	@Column(name = "surname")						// This annotation specify the mapping between the fields of the class and the columns of the database table
	private String surName;
	@Column(name = "firstname")
	private String firstName;
	
	@OneToOne										// This annotation indicates that this is a One-to-One relationship, meaning that each instance of the entity that contains this code is associated with exactly one instance of the "Course" entity, and vice versa.
	@JoinColumn(name = "courseId")					// This annotation specifies the name of the column in the database table of the entity that contains this code that will be used as the foreign key to reference the primary key of the "Course" entity. 				
	private Course course;
	
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	private String dateOfBirth;
	@Column(name = "gender")
	private String gender;


	// Overall, this code defines a simple entity class that can be used to interact with a database table named Student.
}
