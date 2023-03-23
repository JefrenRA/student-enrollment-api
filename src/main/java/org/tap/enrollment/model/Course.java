package org.tap.enrollment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="Course")
@AllArgsConstructor 
@NoArgsConstructor 
@Getter
@Setter
public class Course {
	@Id
	private Long courseId;
	@Column (name = "courseCode")
	private String courseCode;
	@Column (name ="courseDescription")
	private String courseDescription;

}
