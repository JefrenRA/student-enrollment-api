package org.tap.enrollment.model.request.account;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInfoRequest implements Serializable {
	
	private static final long serialVersionUID = -411404243542092196L;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "Username") 
	private String username;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "Password")
	private String password;
	
	@NotNull
	@NotEmpty
	@JsonProperty(value = "Role")
	private String role;
}
