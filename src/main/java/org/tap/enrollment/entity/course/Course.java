package org.tap.enrollment.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 											// This annotation indicates that this class maps to a database table
@Table(name="Course") 								// This annotation specifies the name of the table
@AllArgsConstructor     							// These annotations generate constructors with all arguments and no arguments, respectively. 
@NoArgsConstructor      							// It further reduce code and simplify object instantiation.
@Getter
@Setter                 							// These annotations generates getter and setter methods for the fields of the class automatically

public class Course {
	@Id                                             // This annotation indicates that the courseId field is the primary key for the table
	@GeneratedValue(generator = "system-uuid")		// This annotation allows the system to use string as primary key
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String courseCode;
	@Column (name ="courseDescription")
	private String courseDescription;

}
	// Overall, this code defines a simple entity class that can be used to interact with a database table named Course.
