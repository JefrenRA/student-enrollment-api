package org.tap.enrollment.model.request.subject;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //These annotations generates getter and setter methods for the fields of the class automatically
public class SubjectInfoRequest implements Serializable{
	
	/*
	 * The class implements the Serializable interface, which allows objects of this class to be serialized 
	 * and deserialized, i.e., converted to and from a stream of bytes for storage or transmission
	 */
	
	private static final long serialVersionUID = -411404243542092196L;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "SubjectId")
	private Long subjectId;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "SubjectCode")
	private String subjectCode;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "SubjectDescription")
	private String description;
	
	/*
	 * Overall, this code file defines a class with six string properties that can be serialized 
	 * and deserialized to and from JSON, with the help of Jackson annotations.
	 */
}
