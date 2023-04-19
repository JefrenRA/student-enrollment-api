package org.tap.enrollment.model.request.course;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	// These annotations generates getter and setter methods for the fields of the class automatically

public class CourseInfoRequest implements Serializable{

	/*
	 * The class implements the Serializable interface, which allows objects of this class to be serialized
	 * and deserialized, i.e., converted to and from a stream of bytes for storage or transmission
	 */

	private static final long serialVersionUID = -411404243542092196L;

	// @JsonProperty is used to specify how a JSON object property is mapped to a Java object field.
	@NotNull
	@NotEmpty
	@JsonProperty(value = "CourseCode")
	private String courseCode;

	@NotNull
	@NotEmpty
	@JsonProperty(value = "CourseDescription")
	private String courseDescription;

}

	/*
	 * Overall, this code file defines a class with two string properties that can be serialized
	 * and deserialized to and from JSON, with the help of Jackson annotations.
	 */
