package org.tap.enrollment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="Student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	@Column(name = "surname")
	private String surName;
	@Column(name = "firstname")
	private String firstName;
	
	@OneToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	private String dateOfBirth;
	@Column(name = "gender")
	private String gender;

}
