package org.tap.enrollment.entity.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 											// This annotation indicates that this class maps to a database table
@Table(name="Subject") 								// This annotation specifies the name of the table
@AllArgsConstructor     							// These annotations generate constructors with all arguments and no arguments, respectively.
@NoArgsConstructor      							// It further reduce code and simplify object instantiation.
@Getter
@Setter                 							// These annotations generates getter and setter methods for the fields of the class automatically

public class Subject {
	@Id                                             // This annotation indicates that the courseId field is the primary key for the table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation specifies that the database should allow the user to input a unique id
	private Long subjectId;
	@Column (name = "subjectCode") 					// This annotation specify the mapping between the fields of the class and the columns of the database table
	private String subjectCode;
	@Column (name ="subjectDescription")
	private String subjectDescription;

}

	// Overall, this code defines a simple entity class that can be used to interact with a database table named Course.
