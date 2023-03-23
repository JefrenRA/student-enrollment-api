package org.tap.enrollment.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Test {

	private Long id;
	private String firstName;
}
